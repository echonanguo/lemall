package org.echonanguo.lemall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.mbg.model.CmsSubject;
import org.echonanguo.lemall.mbg.model.CmsSubjectExample;

public interface CmsSubjectMapper {
    long countByExample(CmsSubjectExample example);

    int deleteByExample(CmsSubjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsSubject row);

    int insertSelective(CmsSubject row);

    List<CmsSubject> selectByExampleWithBLOBs(CmsSubjectExample example);

    List<CmsSubject> selectByExample(CmsSubjectExample example);

    CmsSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") CmsSubject row, @Param("example") CmsSubjectExample example);

    int updateByExampleWithBLOBs(@Param("row") CmsSubject row, @Param("example") CmsSubjectExample example);

    int updateByExample(@Param("row") CmsSubject row, @Param("example") CmsSubjectExample example);

    int updateByPrimaryKeySelective(CmsSubject row);

    int updateByPrimaryKeyWithBLOBs(CmsSubject row);

    int updateByPrimaryKey(CmsSubject row);
}
