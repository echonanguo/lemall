package org.echonanguo.lemall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.common.model.UmsAdminRoleRelation;
import org.echonanguo.lemall.common.model.UmsResource;
import org.echonanguo.lemall.common.model.UmsRole;

import java.util.List;

public interface UmsAdminRoleRelationMapper extends BaseMapper<UmsAdminRoleRelation> {
    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list") List<UmsAdminRoleRelation> adminRoleRelationList);

    /**
     * 获取用于所有角色
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有可访问资源
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 获取资源相关用户ID列表
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);
}
