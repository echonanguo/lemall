package org.nanguo.lemall.business.admin.system.service;

import org.nanguo.lemall.business.admin.system.entity.UmsMenu;
import org.nanguo.lemall.business.admin.system.entity.UmsRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UmsRoleService extends IService<UmsRole>{


    /**
     * 根据管理员ID获取对应菜单
     */
    List<UmsMenu> getMenuList(Long id);
}
