package org.nanguo.lemall.business.admin.system.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import org.nanguo.lemall.business.admin.system.entity.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
public interface UmsAdminService extends IService<UmsAdmin>{


    SaTokenInfo login(String username, String password);
}
