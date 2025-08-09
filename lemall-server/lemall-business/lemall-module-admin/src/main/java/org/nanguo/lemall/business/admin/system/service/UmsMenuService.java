package org.nanguo.lemall.business.admin.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.nanguo.lemall.business.admin.system.dto.response.UmsMenuNodeResponseDTO;
import org.nanguo.lemall.business.admin.system.dto.response.UmsMenuResponseDTO;
import org.nanguo.lemall.business.admin.system.entity.UmsMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UmsMenuService extends IService<UmsMenu>{

    /**
     * 树结构返回菜单
     * @return 结果
     */
    List<UmsMenuNodeResponseDTO> treeList();

    /**
     * 分页查询菜单
     * @param parentId 父节点id
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @return 分页结果
     */
    IPage<UmsMenuResponseDTO> pageMenu(Long parentId, Integer pageNum, Integer pageSize);
}
