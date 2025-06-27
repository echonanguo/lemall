package org.echonanguo.lemall.admin.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.echonanguo.lemall.admin.dto.UmsAdminParam;
import org.echonanguo.lemall.admin.dto.UpdateAdminPasswordParam;
import org.echonanguo.lemall.admin.mapper.UmsAdminLoginLogMapper;
import org.echonanguo.lemall.admin.mapper.UmsAdminRoleRelationMapper;
import org.echonanguo.lemall.admin.service.UmsAdminService;
import org.echonanguo.lemall.admin.service.UmsAdminCacheService;
import org.echonanguo.lemall.common.constant.AuthConstant;
import org.echonanguo.lemall.common.dto.UserDto;
import org.echonanguo.lemall.common.exception.Asserts;
import org.echonanguo.lemall.common.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.echonanguo.lemall.admin.mapper.UmsAdminMapper;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {
    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;
    @Autowired
    private UmsAdminLoginLogMapper loginLogMapper;
    @Autowired
    private UmsAdminCacheService adminCacheService;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        return baseMapper.selectOne(
                new LambdaQueryWrapper<UmsAdmin>().eq(UmsAdmin::getUsername, username)
        );
    }

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        //查询是否有相同用户名的用户
        List<UmsAdmin> umsAdminList = baseMapper.selectList(
                new LambdaQueryWrapper<UmsAdmin>()
                        .eq(UmsAdmin::getUsername, umsAdmin.getUsername())
        );
        if (!umsAdminList.isEmpty()) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = BCrypt.hashpw(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        baseMapper.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public SaTokenInfo login(String username, String password) {
        if(StrUtil.isEmpty(username)||StrUtil.isEmpty(password)){
            Asserts.fail("用户名或密码不能为空！");
        }
        UmsAdmin admin = getAdminByUsername(username);
        if(admin==null){
            Asserts.fail("找不到该用户！");
        }
        if (!BCrypt.checkpw(password, admin.getPassword())) {
            Asserts.fail("密码不正确！");
        }
        if(admin.getStatus()!=1){
            Asserts.fail("该账号已被禁用！");
        }
        // 登录校验成功后，一行代码实现登录
        StpUtil.login(admin.getId());
        UserDto userDto = new UserDto();
        userDto.setId(admin.getId());
        userDto.setUsername(admin.getUsername());
        userDto.setClientId(AuthConstant.ADMIN_CLIENT_ID);
        List<UmsResource> resourceList = getResourceList(admin.getId());
        List<String> permissionList = resourceList.stream().map(item -> item.getId() + ":" + item.getName()).toList();
        userDto.setPermissionList(permissionList);
        // 将用户信息存储到Session中
        StpUtil.getSession().set(AuthConstant.STP_ADMIN_INFO,userDto);
        // 获取当前登录用户Token信息
        SaTokenInfo saTokenInfo = StpUtil.getTokenInfo();
//        updateLoginTimeByUsername(username);
        insertLoginLog(admin);
        return saTokenInfo;
    }

    /**
     * 添加登录记录
     */
    private void insertLoginLog(UmsAdmin admin) {
        if(admin==null) return;
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        loginLogMapper.insert(loginLog);
    }

    /**
     * 根据用户名修改登录时间
     */
    private void updateLoginTimeByUsername(String username) {
        UmsAdmin record = new UmsAdmin();
        record.setLoginTime(new Date());
        baseMapper.update(record,
                new LambdaUpdateWrapper<UmsAdmin>()
                        .eq(UmsAdmin::getUsername, username));
    }

    @Override
    public UmsAdmin getItem(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        return baseMapper.selectPage(
                new Page<>(pageNum, pageSize),
                Wrappers.<UmsAdmin>lambdaQuery()
                        .and(StringUtils.hasText(keyword), w -> w
                                .like(UmsAdmin::getUsername, keyword)
                                .or()
                                .like(UmsAdmin::getNickName, keyword)
                        )
        ).getRecords();
    }

    @Override
    public int update(Long id, UmsAdmin admin) {
        admin.setId(id);
        UmsAdmin rawAdmin = baseMapper.selectById(id);
        if(rawAdmin.getPassword().equals(admin.getPassword())){
            //与原加密密码相同的不需要修改
            admin.setPassword(null);
        }else{
            //与原加密密码不同的需要加密修改
            if(StrUtil.isEmpty(admin.getPassword())){
                admin.setPassword(null);
            }else{
                admin.setPassword(BCrypt.hashpw(admin.getPassword()));
            }
        }
        int count = baseMapper.updateById(admin);
        adminCacheService.delAdmin(id);
        return count;
    }

    @Override
    public int delete(Long id) {
        int count = baseMapper.deleteById(id);
        adminCacheService.delAdmin(id);
        return count;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //先删除原来的关系
        adminRoleRelationMapper.delete(
                Wrappers.<UmsAdminRoleRelation>lambdaQuery()
                        .eq(UmsAdminRoleRelation::getAdminId, adminId)
        );
        //建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<UmsAdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                UmsAdminRoleRelation roleRelation = new UmsAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            adminRoleRelationMapper.insertList(list);
        }
        return count;
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return adminRoleRelationMapper.getRoleList(adminId);
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        return adminRoleRelationMapper.getResourceList(adminId);
    }

    @Override
    public int updatePassword(UpdateAdminPasswordParam param) {
        if(StrUtil.isEmpty(param.getUsername())
                ||StrUtil.isEmpty(param.getOldPassword())
                ||StrUtil.isEmpty(param.getNewPassword())){
            return -1;
        }
        List<UmsAdmin> adminList = baseMapper.selectList(
                Wrappers.<UmsAdmin>lambdaQuery()
                .eq(UmsAdmin::getUsername, param.getUsername())
        );
        if(CollUtil.isEmpty(adminList)){
            return -2;
        }
        UmsAdmin umsAdmin = adminList.get(0);
        if(!BCrypt.checkpw(param.getOldPassword(),umsAdmin.getPassword())){
            return -3;
        }
        umsAdmin.setPassword(BCrypt.hashpw(param.getNewPassword()));
        baseMapper.updateById(umsAdmin);
        adminCacheService.delAdmin(umsAdmin.getId());
        return 1;
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
    public void logout() {
        //先清空缓存
        UserDto userDto = (UserDto) StpUtil.getSession().get(AuthConstant.STP_ADMIN_INFO);
        adminCacheService.delAdmin(userDto.getId());
        //再调用sa-token的登出方法
        StpUtil.logout();
    }
}
