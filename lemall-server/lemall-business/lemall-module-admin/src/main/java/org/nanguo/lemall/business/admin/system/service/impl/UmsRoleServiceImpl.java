package org.nanguo.lemall.business.admin.system.service.impl;

import org.nanguo.lemall.business.admin.system.entity.UmsMenu;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.nanguo.lemall.business.admin.system.entity.UmsRole;
import org.nanguo.lemall.business.admin.system.mapper.UmsRoleMapper;
import org.nanguo.lemall.business.admin.system.service.UmsRoleService;

import java.util.List;

@Service
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole> implements UmsRoleService{

    @Override
    public List<UmsMenu> getMenuList(Long id) {
        return baseMapper.getMenuList(id);
    }
}
