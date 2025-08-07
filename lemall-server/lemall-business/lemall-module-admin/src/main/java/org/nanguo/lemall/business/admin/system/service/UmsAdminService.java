package org.nanguo.lemall.business.admin.system.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import org.nanguo.lemall.business.admin.system.entity.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import org.nanguo.lemall.business.admin.system.entity.UmsRole;

import java.util.List;

public interface UmsAdminService extends IService<UmsAdmin>{


    SaTokenInfo login(String username, String password);

    UmsAdmin getCurrentAdmin();

    /**
     * 获取用户对于角色
     */
    List<UmsRole> getRoleList(Long id);
}
