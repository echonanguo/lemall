package org.echonanguo.lemall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.mbg.model.CmsSubjectCategory;
import org.echonanguo.lemall.mbg.model.CmsSubjectCategoryExample;

public interface CmsSubjectCategoryMapper {
    long countByExample(CmsSubjectCategoryExample example);

    int deleteByExample(CmsSubjectCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsSubjectCategory row);

    int insertSelective(CmsSubjectCategory row);

    List<CmsSubjectCategory> selectByExample(CmsSubjectCategoryExample example);

    CmsSubjectCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") CmsSubjectCategory row, @Param("example") CmsSubjectCategoryExample example);

    int updateByExample(@Param("row") CmsSubjectCategory row, @Param("example") CmsSubjectCategoryExample example);

    int updateByPrimaryKeySelective(CmsSubjectCategory row);

    int updateByPrimaryKey(CmsSubjectCategory row);
}
