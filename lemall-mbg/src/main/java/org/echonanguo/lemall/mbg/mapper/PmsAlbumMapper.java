package org.echonanguo.lemall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.mbg.model.PmsAlbum;
import org.echonanguo.lemall.mbg.model.PmsAlbumExample;

public interface PmsAlbumMapper {
    long countByExample(PmsAlbumExample example);

    int deleteByExample(PmsAlbumExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsAlbum row);

    int insertSelective(PmsAlbum row);

    List<PmsAlbum> selectByExample(PmsAlbumExample example);

    PmsAlbum selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") PmsAlbum row, @Param("example") PmsAlbumExample example);

    int updateByExample(@Param("row") PmsAlbum row, @Param("example") PmsAlbumExample example);

    int updateByPrimaryKeySelective(PmsAlbum row);

    int updateByPrimaryKey(PmsAlbum row);
}
