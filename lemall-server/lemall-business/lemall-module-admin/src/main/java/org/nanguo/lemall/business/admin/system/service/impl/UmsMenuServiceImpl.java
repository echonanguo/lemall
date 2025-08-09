package org.nanguo.lemall.business.admin.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.nanguo.lemall.business.admin.system.dto.response.UmsMenuNodeResponseDTO;
import org.nanguo.lemall.business.admin.system.dto.response.UmsMenuResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.nanguo.lemall.business.admin.system.mapper.UmsMenuMapper;
import org.nanguo.lemall.business.admin.system.entity.UmsMenu;
import org.nanguo.lemall.business.admin.system.service.UmsMenuService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UmsMenuServiceImpl extends ServiceImpl<UmsMenuMapper, UmsMenu> implements UmsMenuService {

    @Override
    public List<UmsMenuNodeResponseDTO> treeList() {
        // 先把 UmsMenu 转成 DTO 列表
        List<UmsMenuNodeResponseDTO> menuList = super.list(Wrappers.<UmsMenu>lambdaQuery().orderByDesc(UmsMenu::getSort).orderByDesc(UmsMenu::getCreateTime)).stream().map(umsMenu -> {
            UmsMenuNodeResponseDTO dto = new UmsMenuNodeResponseDTO();
            BeanUtils.copyProperties(umsMenu, dto);
            return dto;
        }).collect(Collectors.toList());

        // 构建树形结构（只取 parentId=0 的作为根节点）
        return menuList.stream()
                .filter(menu -> menu.getParentId() == 0L)
                .map(menu -> buildMenuTree(menu, menuList))
                .collect(Collectors.toList());
    }

    @Override
    public IPage<UmsMenuResponseDTO> pageMenu(Long parentId, Integer pageNum, Integer pageSize) {
        return baseMapper.selectPage(new Page<>(pageNum, pageSize), Wrappers.<UmsMenu>lambdaQuery()
                .eq(UmsMenu::getParentId, parentId)
                .orderByDesc(UmsMenu::getSort)
                .orderByDesc(UmsMenu::getCreateTime)
        ).convert(umsMenu -> {
            UmsMenuResponseDTO dto = new UmsMenuResponseDTO();
            BeanUtils.copyProperties(umsMenu, dto);
            return dto;
        });
    }

    /**
     * 递归构建菜单树
     */
    private UmsMenuNodeResponseDTO buildMenuTree(UmsMenuNodeResponseDTO menu, List<UmsMenuNodeResponseDTO> menuList) {
        List<UmsMenuNodeResponseDTO> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> buildMenuTree(subMenu, menuList))
                .collect(Collectors.toList());
        menu.setChildren(children);
        return menu;
    }
}
