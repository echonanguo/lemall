package org.echonanguo.lemall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.echonanguo.lemall.admin.mapper.UmsRoleMenuRelationMapper;
import org.echonanguo.lemall.admin.mapper.UmsRoleResourceRelationMapper;
import org.echonanguo.lemall.admin.service.UmsResourceService;
import org.echonanguo.lemall.admin.service.UmsRoleService;
import org.echonanguo.lemall.common.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.echonanguo.lemall.admin.mapper.UmsRoleMapper;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
/**
 * 后台角色管理Service实现类
 * Created by echonanguo on 2025/1/22.
 */
@Service
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole> implements UmsRoleService {
    @Autowired
    private UmsRoleMenuRelationMapper roleMenuRelationMapper;
    @Autowired
    private UmsRoleResourceRelationMapper roleResourceRelationMapper;
    @Autowired
    private UmsResourceService resourceService;
    @Override
    public int create(UmsRole role) {
        role.setCreateTime(new Date());
        role.setAdminCount(0);
        role.setSort(0);
        return baseMapper.insert(role);
    }

    @Override
    public int update(Long id, UmsRole role) {
        role.setId(id);
        return baseMapper.updateById(role);
    }

    @Override
    public int delete(List<Long> ids) {
        int count = baseMapper.delete(Wrappers.<UmsRole>lambdaQuery()
                .in(UmsRole::getId, ids)
        );
        resourceService.initPathResourceMap();
        return count;
    }

    @Override
    public List<UmsRole> list() {
        return baseMapper.selectList(null);
    }

    @Override
    public List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum) {
        // 创建分页对象
        Page<UmsRole> page = new Page<>(pageNum, pageSize);

        // 构建查询条件
        LambdaQueryWrapper<UmsRole> queryWrapper = new LambdaQueryWrapper<>();

        if (StringUtils.hasText(keyword)) {
            queryWrapper.like(UmsRole::getName, keyword);
        }

        // 执行分页查询
        return baseMapper.selectPage(page, queryWrapper).getRecords();
    }

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return baseMapper.getMenuList(adminId);
    }

    @Override
    public List<UmsMenu> listMenu(Long roleId) {
        return baseMapper.getMenuListByRoleId(roleId);
    }

    @Override
    public List<UmsResource> listResource(Long roleId) {
        return baseMapper.getResourceListByRoleId(roleId);
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        roleMenuRelationMapper.delete(Wrappers.<UmsRoleMenuRelation>lambdaQuery()
        .eq(UmsRoleMenuRelation::getRoleId, roleId)
        );
        //批量插入新关系
        for (Long menuId : menuIds) {
            UmsRoleMenuRelation relation = new UmsRoleMenuRelation();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            roleMenuRelationMapper.insert(relation);
        }
        return menuIds.size();
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        roleResourceRelationMapper.delete(Wrappers.<UmsRoleResourceRelation>lambdaQuery()
        .eq(UmsRoleResourceRelation::getRoleId, roleId)
        );
        //批量插入新关系
        for (Long resourceId : resourceIds) {
            UmsRoleResourceRelation relation = new UmsRoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            roleResourceRelationMapper.insert(relation);
        }
        resourceService.initPathResourceMap();
        return resourceIds.size();
    }
}
