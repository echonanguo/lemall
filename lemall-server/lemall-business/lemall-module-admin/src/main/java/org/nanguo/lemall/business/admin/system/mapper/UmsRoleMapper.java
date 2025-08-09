package org.nanguo.lemall.business.admin.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.nanguo.lemall.business.admin.system.dto.response.UmsMenuResponseDTO;
import org.nanguo.lemall.business.admin.system.dto.response.UmsResourceResponseDTO;
import org.nanguo.lemall.business.admin.system.entity.UmsMenu;
import org.nanguo.lemall.business.admin.system.entity.UmsRole;

import java.util.List;

public interface UmsRoleMapper extends BaseMapper<UmsRole> {
    /**
     * 根据后台用户ID获取菜单
     */
    List<UmsMenu> getMenuList(Long id);

    /**
     * 根据角色id查菜单
     * @param roleId 角色id
     * @return 菜单列表
     */
    List<UmsMenuResponseDTO> getMenuListByRoleId(Long roleId);

    /**
     * 根据角色ID获取资源
     */
    List<UmsResourceResponseDTO> getResourceListByRoleId(Long roleId);
}