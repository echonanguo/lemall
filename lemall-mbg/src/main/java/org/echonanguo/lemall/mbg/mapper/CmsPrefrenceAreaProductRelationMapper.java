package org.echonanguo.lemall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.mbg.model.CmsPrefrenceAreaProductRelation;
import org.echonanguo.lemall.mbg.model.CmsPrefrenceAreaProductRelationExample;

public interface CmsPrefrenceAreaProductRelationMapper {
    long countByExample(CmsPrefrenceAreaProductRelationExample example);

    int deleteByExample(CmsPrefrenceAreaProductRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsPrefrenceAreaProductRelation row);

    int insertSelective(CmsPrefrenceAreaProductRelation row);

    List<CmsPrefrenceAreaProductRelation> selectByExample(CmsPrefrenceAreaProductRelationExample example);

    CmsPrefrenceAreaProductRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") CmsPrefrenceAreaProductRelation row, @Param("example") CmsPrefrenceAreaProductRelationExample example);

    int updateByExample(@Param("row") CmsPrefrenceAreaProductRelation row, @Param("example") CmsPrefrenceAreaProductRelationExample example);

    int updateByPrimaryKeySelective(CmsPrefrenceAreaProductRelation row);

    int updateByPrimaryKey(CmsPrefrenceAreaProductRelation row);
}
