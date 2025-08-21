package org.nanguo.lemall.business.admin.system.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.nanguo.lemall.auth.constant.AuthConstant;
import org.nanguo.lemall.business.admin.system.dto.request.UmsAdminRequestDTO;
import org.nanguo.lemall.business.admin.system.dto.response.UmsAdminResponseDTO;
import org.nanguo.lemall.business.admin.system.dto.response.UmsRoleResponseDTO;
import org.nanguo.lemall.business.admin.system.entity.*;
import org.nanguo.lemall.business.admin.system.mapper.UmsAdminLoginLogMapper;
import org.nanguo.lemall.business.admin.system.service.UmsAdminCacheService;
import org.nanguo.lemall.business.admin.system.service.UmsAdminRoleRelationService;
import org.nanguo.lemall.business.admin.system.service.UmsRoleService;
import org.nanguo.lemall.dto.UserDto;
import org.nanguo.lemall.util.response.BizException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.nanguo.lemall.business.admin.system.mapper.UmsAdminMapper;
import org.nanguo.lemall.business.admin.system.service.UmsAdminService;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

    private final UmsAdminLoginLogMapper loginLogMapper;
    private final UmsAdminCacheService adminCacheService;
    private final UmsAdminRoleRelationService userRoleRelationService;
    private final UmsRoleService roleService;

    @Override
    public SaTokenInfo login(String username, String password) {
        // 1.与数据库核实登录信息是否正确
        UmsAdmin umsAdmin = baseMapper.selectOne(Wrappers.<UmsAdmin>lambdaQuery()
                .eq(UmsAdmin::getUsername, username)
        );
        if (umsAdmin == null) {
            throw new BizException("该用户不存在");
        }
        if (!BCrypt.checkpw(password, umsAdmin.getPassword())) {
            throw new BizException("密码不正确！");
        }
        if (umsAdmin.getStatus() != 1) {
            throw new BizException("该账号已被禁用！");
        }
        // 2.校验成功后，存储登录信息，并返回token
        StpUtil.login(umsAdmin.getId());
        // 记录登录信息
        umsAdmin.setLoginTime(new Date());
        baseMapper.updateById(umsAdmin);
        UserDto userDto = new UserDto();
        userDto.setId(umsAdmin.getId());
        userDto.setUsername(umsAdmin.getUsername());
        userDto.setClientId(AuthConstant.ADMIN_CLIENT_ID);
        List<UmsResource> resourceList = baseMapper.getResourceList(umsAdmin.getId());
        List<String> permissionList = resourceList.stream().map(item -> item.getId() + ":" + item.getName()).toList();
        userDto.setPermissionList(permissionList);
        // 将用户信息存储到Session中
        StpUtil.getSession().set(AuthConstant.STP_ADMIN_INFO, userDto);
        // 获取当前登录用户Token信息
        SaTokenInfo saTokenInfo = StpUtil.getTokenInfo();
        // 记录登录日志
        insertLoginLog(umsAdmin);
        return saTokenInfo;
    }

    @Override
    public UmsAdmin getCurrentAdmin() {
        UserDto userDto = (UserDto) StpUtil.getSession().get(AuthConstant.STP_ADMIN_INFO);
        UmsAdmin admin = adminCacheService.getAdmin(userDto.getId());
        if (admin == null) {
            admin = baseMapper.selectById(userDto.getId());
            adminCacheService.setAdmin(admin);
        }
        return admin;
    }

    @Override
    public List<UmsRoleResponseDTO> getRoleList(Long id) {
        List<UmsRole> roleList = baseMapper.getRoleList(id);
        return roleList.stream().map(role -> {
            UmsRoleResponseDTO umsRoleResponseDTO = new UmsRoleResponseDTO();
            BeanUtils.copyProperties(role, umsRoleResponseDTO);
            return umsRoleResponseDTO;
        }).toList();
    }

    @Override
    public IPage<UmsAdminResponseDTO> list(String keyword, Integer pageSize, Integer pageNum) {
        Page<UmsAdmin> adminPage = super.page(new Page<>(pageNum, pageSize), Wrappers.<UmsAdmin>lambdaQuery()
                .like(StringUtils.hasText(keyword), UmsAdmin::getUsername, keyword)
                .or()
                .like(StringUtils.hasText(keyword), UmsAdmin::getNickName, keyword)
                .orderByDesc(UmsAdmin::getCreateTime)
        );
        return adminPage.convert(admin -> {
            UmsAdminResponseDTO umsAdminResponseDTO = new UmsAdminResponseDTO();
            BeanUtils.copyProperties(admin, umsAdminResponseDTO);
            return umsAdminResponseDTO;
        });
    }

    @Override
    public UmsAdminResponseDTO register(UmsAdminRequestDTO umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(umsAdminParam.getStatus());
        //查询是否有相同用户名的用户
        List<UmsAdmin> umsAdmins = baseMapper.selectList(Wrappers.<UmsAdmin>lambdaQuery().eq(UmsAdmin::getUsername, umsAdmin.getUsername()));
        if (!umsAdmins.isEmpty()) {
            throw new BizException("用户名已存在");
        }
        //将密码进行加密操作
        String encodePassword = BCrypt.hashpw(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        baseMapper.insert(umsAdmin);
        UmsAdminResponseDTO umsAdminResponseDTO = new UmsAdminResponseDTO();
        BeanUtils.copyProperties(umsAdmin, umsAdminResponseDTO);
        return umsAdminResponseDTO;
    }

    @Override
    public boolean updateAdmin(Long id, UmsAdminRequestDTO umsAdminRequestDTO) {
        // 如何username不为null说明是编辑
        if (umsAdminRequestDTO.getUsername() != null) {
            List<UmsAdmin> umsAdmins = baseMapper.selectList(Wrappers.<UmsAdmin>lambdaQuery().eq(UmsAdmin::getUsername, umsAdminRequestDTO.getUsername()));
            if (!umsAdmins.isEmpty()) {
                Long tempId = umsAdmins.get(0).getId();
                if (!tempId.equals(id)) {
                    throw new BizException("用户名已存在");
                }
            }
        }
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setId(id);
        BeanUtils.copyProperties(umsAdminRequestDTO, umsAdmin);
        return super.updateById(umsAdmin);
    }

    @Override
    public boolean deleteAdmin(Long id) {
        List<UmsRole> roleList = baseMapper.getRoleList(id);
        roleList.forEach(role -> {
            role.setAdminCount(role.getAdminCount() - 1);
        });
        roleService.updateBatchById(roleList);
        userRoleRelationService.remove(Wrappers.<UmsAdminRoleRelation>lambdaQuery().eq(UmsAdminRoleRelation::getAdminId, id));
        return super.removeById(id);
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        // 原来的角色计数器-1
        List<UmsRole> umsRoles1 = baseMapper.getRoleList(adminId);
        umsRoles1.forEach(umsRole -> {
            umsRole.setAdminCount(umsRole.getAdminCount() - 1);
        });
        roleService.updateBatchById(umsRoles1);
        //先删除原来的关系
        userRoleRelationService.remove(Wrappers.<UmsAdminRoleRelation>lambdaQuery()
                .eq(UmsAdminRoleRelation::getAdminId, adminId));
        //建立新关系
        List<UmsAdminRoleRelation> list = new ArrayList<>();
        if (roleIds != null) {
            roleIds.forEach(roleId -> {
                UmsAdminRoleRelation roleRelation = new UmsAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            });
        }
        userRoleRelationService.saveBatch(list);
        // 最新的角色计数器+1
        List<UmsRole> umsRoles2 = roleService.listByIds(roleIds);
        umsRoles2.forEach(umsRole -> {
            umsRole.setAdminCount(umsRole.getAdminCount() + 1);
        });
        roleService.updateBatchById(umsRoles2);
        return count;
    }

    /**
     * 添加登录记录
     */
    private void insertLoginLog(UmsAdmin admin) {
        if (admin == null) return;
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        loginLogMapper.insert(loginLog);
    }
}
