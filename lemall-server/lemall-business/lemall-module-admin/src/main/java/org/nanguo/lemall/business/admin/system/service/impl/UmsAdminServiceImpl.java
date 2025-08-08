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
import org.nanguo.lemall.business.admin.system.entity.UmsAdminLoginLog;
import org.nanguo.lemall.business.admin.system.entity.UmsResource;
import org.nanguo.lemall.business.admin.system.entity.UmsRole;
import org.nanguo.lemall.business.admin.system.mapper.UmsAdminLoginLogMapper;
import org.nanguo.lemall.business.admin.system.service.UmsAdminCacheService;
import org.nanguo.lemall.dto.UserDto;
import org.nanguo.lemall.util.response.BizException;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.nanguo.lemall.business.admin.system.mapper.UmsAdminMapper;
import org.nanguo.lemall.business.admin.system.entity.UmsAdmin;
import org.nanguo.lemall.business.admin.system.service.UmsAdminService;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

    private final UmsAdminLoginLogMapper loginLogMapper;
    private final UmsAdminCacheService adminCacheService;

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
    public List<UmsRole> getRoleList(Long id) {
        return baseMapper.getRoleList(id);
    }

    @Override
    public IPage<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        return super.page(new Page<>(pageNum, pageSize), Wrappers.<UmsAdmin>lambdaQuery()
                .like(StringUtils.hasText(keyword), UmsAdmin::getUsername, keyword)
                .or()
                .like(StringUtils.hasText(keyword), UmsAdmin::getNickName, keyword)
        );
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
