package org.echonanguo.lemall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.mbg.model.OmsOrderItem;
import org.echonanguo.lemall.mbg.model.OmsOrderItemExample;

public interface OmsOrderItemMapper {
    long countByExample(OmsOrderItemExample example);

    int deleteByExample(OmsOrderItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderItem row);

    int insertSelective(OmsOrderItem row);

    List<OmsOrderItem> selectByExample(OmsOrderItemExample example);

    OmsOrderItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") OmsOrderItem row, @Param("example") OmsOrderItemExample example);

    int updateByExample(@Param("row") OmsOrderItem row, @Param("example") OmsOrderItemExample example);

    int updateByPrimaryKeySelective(OmsOrderItem row);

    int updateByPrimaryKey(OmsOrderItem row);
}
