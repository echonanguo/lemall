package org.echonanguo.lemall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.mbg.model.UmsPermission;
import org.echonanguo.lemall.mbg.model.UmsPermissionExample;

public interface UmsPermissionMapper {
    long countByExample(UmsPermissionExample example);

    int deleteByExample(UmsPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsPermission row);

    int insertSelective(UmsPermission row);

    List<UmsPermission> selectByExample(UmsPermissionExample example);

    UmsPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") UmsPermission row, @Param("example") UmsPermissionExample example);

    int updateByExample(@Param("row") UmsPermission row, @Param("example") UmsPermissionExample example);

    int updateByPrimaryKeySelective(UmsPermission row);

    int updateByPrimaryKey(UmsPermission row);
}
