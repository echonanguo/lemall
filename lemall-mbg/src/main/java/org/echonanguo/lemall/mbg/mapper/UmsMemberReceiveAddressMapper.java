package org.echonanguo.lemall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.mbg.model.UmsMemberReceiveAddress;
import org.echonanguo.lemall.mbg.model.UmsMemberReceiveAddressExample;

public interface UmsMemberReceiveAddressMapper {
    long countByExample(UmsMemberReceiveAddressExample example);

    int deleteByExample(UmsMemberReceiveAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberReceiveAddress row);

    int insertSelective(UmsMemberReceiveAddress row);

    List<UmsMemberReceiveAddress> selectByExample(UmsMemberReceiveAddressExample example);

    UmsMemberReceiveAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") UmsMemberReceiveAddress row, @Param("example") UmsMemberReceiveAddressExample example);

    int updateByExample(@Param("row") UmsMemberReceiveAddress row, @Param("example") UmsMemberReceiveAddressExample example);

    int updateByPrimaryKeySelective(UmsMemberReceiveAddress row);

    int updateByPrimaryKey(UmsMemberReceiveAddress row);
}
