package org.echonanguo.lemall.admin.service;

import org.echonanguo.lemall.admin.dto.UmsMenuNode;
import org.echonanguo.lemall.common.model.UmsMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UmsMenuService extends IService<UmsMenu>{
    /**
     * 创建后台菜单
     */
    int create(UmsMenu umsMenu);

    /**
     * 修改后台菜单
     */
    int update(Long id, UmsMenu umsMenu);

    /**
     * 根据ID获取菜单详情
     */
    UmsMenu getItem(Long id);

    /**
     * 根据ID删除菜单
     */
    int delete(Long id);

    /**
     * 分页查询后台菜单
     */
    List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 树形结构返回所有菜单列表
     */
    List<UmsMenuNode> treeList();

    /**
     * 修改菜单显示状态
     */
    int updateHidden(Long id, Integer hidden);

}
