package org.echonanguo.lemall.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.common.model.UmsMenu;
import org.echonanguo.lemall.common.model.UmsResource;
import org.echonanguo.lemall.common.model.UmsRole;

import java.util.List;

public interface UmsRoleMapper extends BaseMapper<UmsRole> {

    /**
     * 根据后台用户ID获取菜单
     */
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);
    /**
     * 根据角色ID获取菜单
     */
    List<UmsMenu> getMenuListByRoleId(@Param("roleId") Long roleId);
    /**
     * 根据角色ID获取资源
     */
    List<UmsResource> getResourceListByRoleId(@Param("roleId") Long roleId);
}
