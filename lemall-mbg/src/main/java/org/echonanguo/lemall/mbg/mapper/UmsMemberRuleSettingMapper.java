package org.echonanguo.lemall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.mbg.model.UmsMemberRuleSetting;
import org.echonanguo.lemall.mbg.model.UmsMemberRuleSettingExample;

public interface UmsMemberRuleSettingMapper {
    long countByExample(UmsMemberRuleSettingExample example);

    int deleteByExample(UmsMemberRuleSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberRuleSetting row);

    int insertSelective(UmsMemberRuleSetting row);

    List<UmsMemberRuleSetting> selectByExample(UmsMemberRuleSettingExample example);

    UmsMemberRuleSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") UmsMemberRuleSetting row, @Param("example") UmsMemberRuleSettingExample example);

    int updateByExample(@Param("row") UmsMemberRuleSetting row, @Param("example") UmsMemberRuleSettingExample example);

    int updateByPrimaryKeySelective(UmsMemberRuleSetting row);

    int updateByPrimaryKey(UmsMemberRuleSetting row);
}
