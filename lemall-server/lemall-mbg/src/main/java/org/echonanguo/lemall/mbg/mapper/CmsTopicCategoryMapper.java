package org.echonanguo.lemall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.mbg.model.CmsTopicCategory;
import org.echonanguo.lemall.mbg.model.CmsTopicCategoryExample;

public interface CmsTopicCategoryMapper {
    long countByExample(CmsTopicCategoryExample example);

    int deleteByExample(CmsTopicCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsTopicCategory row);

    int insertSelective(CmsTopicCategory row);

    List<CmsTopicCategory> selectByExample(CmsTopicCategoryExample example);

    CmsTopicCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") CmsTopicCategory row, @Param("example") CmsTopicCategoryExample example);

    int updateByExample(@Param("row") CmsTopicCategory row, @Param("example") CmsTopicCategoryExample example);

    int updateByPrimaryKeySelective(CmsTopicCategory row);

    int updateByPrimaryKey(CmsTopicCategory row);
}
