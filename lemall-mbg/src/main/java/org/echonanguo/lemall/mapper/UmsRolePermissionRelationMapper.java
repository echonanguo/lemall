package org.echonanguo.lemall.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.model.UmsRolePermissionRelation;
import org.echonanguo.lemall.model.UmsRolePermissionRelationExample;

public interface UmsRolePermissionRelationMapper {
    long countByExample(UmsRolePermissionRelationExample example);

    int deleteByExample(UmsRolePermissionRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsRolePermissionRelation row);

    int insertSelective(UmsRolePermissionRelation row);

    List<UmsRolePermissionRelation> selectByExample(UmsRolePermissionRelationExample example);

    UmsRolePermissionRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") UmsRolePermissionRelation row, @Param("example") UmsRolePermissionRelationExample example);

    int updateByExample(@Param("row") UmsRolePermissionRelation row, @Param("example") UmsRolePermissionRelationExample example);

    int updateByPrimaryKeySelective(UmsRolePermissionRelation row);

    int updateByPrimaryKey(UmsRolePermissionRelation row);
}