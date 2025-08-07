package org.nanguo.lemall.business.admin.system.service;

import org.nanguo.lemall.business.admin.system.entity.UmsMenu;
import org.nanguo.lemall.business.admin.system.entity.UmsRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UmsRoleService extends IService<UmsRole>{


    List<UmsMenu> getMenuList(Long id);
}
