package org.echonanguo.lemall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.mbg.model.OmsOrderOperateHistory;
import org.echonanguo.lemall.mbg.model.OmsOrderOperateHistoryExample;

public interface OmsOrderOperateHistoryMapper {
    long countByExample(OmsOrderOperateHistoryExample example);

    int deleteByExample(OmsOrderOperateHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderOperateHistory row);

    int insertSelective(OmsOrderOperateHistory row);

    List<OmsOrderOperateHistory> selectByExample(OmsOrderOperateHistoryExample example);

    OmsOrderOperateHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") OmsOrderOperateHistory row, @Param("example") OmsOrderOperateHistoryExample example);

    int updateByExample(@Param("row") OmsOrderOperateHistory row, @Param("example") OmsOrderOperateHistoryExample example);

    int updateByPrimaryKeySelective(OmsOrderOperateHistory row);

    int updateByPrimaryKey(OmsOrderOperateHistory row);
}
