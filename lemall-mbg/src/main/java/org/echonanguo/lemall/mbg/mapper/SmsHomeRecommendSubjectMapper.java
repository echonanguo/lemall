package org.echonanguo.lemall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.mbg.model.SmsHomeRecommendSubject;
import org.echonanguo.lemall.mbg.model.SmsHomeRecommendSubjectExample;

public interface SmsHomeRecommendSubjectMapper {
    long countByExample(SmsHomeRecommendSubjectExample example);

    int deleteByExample(SmsHomeRecommendSubjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeRecommendSubject row);

    int insertSelective(SmsHomeRecommendSubject row);

    List<SmsHomeRecommendSubject> selectByExample(SmsHomeRecommendSubjectExample example);

    SmsHomeRecommendSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") SmsHomeRecommendSubject row, @Param("example") SmsHomeRecommendSubjectExample example);

    int updateByExample(@Param("row") SmsHomeRecommendSubject row, @Param("example") SmsHomeRecommendSubjectExample example);

    int updateByPrimaryKeySelective(SmsHomeRecommendSubject row);

    int updateByPrimaryKey(SmsHomeRecommendSubject row);
}
