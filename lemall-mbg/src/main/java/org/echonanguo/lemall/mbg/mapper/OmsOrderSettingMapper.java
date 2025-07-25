package org.echonanguo.lemall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.mbg.model.OmsOrderSetting;
import org.echonanguo.lemall.mbg.model.OmsOrderSettingExample;

public interface OmsOrderSettingMapper {
    long countByExample(OmsOrderSettingExample example);

    int deleteByExample(OmsOrderSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderSetting row);

    int insertSelective(OmsOrderSetting row);

    List<OmsOrderSetting> selectByExample(OmsOrderSettingExample example);

    OmsOrderSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") OmsOrderSetting row, @Param("example") OmsOrderSettingExample example);

    int updateByExample(@Param("row") OmsOrderSetting row, @Param("example") OmsOrderSettingExample example);

    int updateByPrimaryKeySelective(OmsOrderSetting row);

    int updateByPrimaryKey(OmsOrderSetting row);
}
