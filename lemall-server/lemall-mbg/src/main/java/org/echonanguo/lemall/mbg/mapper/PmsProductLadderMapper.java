package org.echonanguo.lemall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.mbg.model.PmsProductLadder;
import org.echonanguo.lemall.mbg.model.PmsProductLadderExample;

public interface PmsProductLadderMapper {
    long countByExample(PmsProductLadderExample example);

    int deleteByExample(PmsProductLadderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductLadder row);

    int insertSelective(PmsProductLadder row);

    List<PmsProductLadder> selectByExample(PmsProductLadderExample example);

    PmsProductLadder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") PmsProductLadder row, @Param("example") PmsProductLadderExample example);

    int updateByExample(@Param("row") PmsProductLadder row, @Param("example") PmsProductLadderExample example);

    int updateByPrimaryKeySelective(PmsProductLadder row);

    int updateByPrimaryKey(PmsProductLadder row);
}
