package org.echonanguo.lemall.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.model.PmsAlbumPic;
import org.echonanguo.lemall.model.PmsAlbumPicExample;

public interface PmsAlbumPicMapper {
    long countByExample(PmsAlbumPicExample example);

    int deleteByExample(PmsAlbumPicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsAlbumPic row);

    int insertSelective(PmsAlbumPic row);

    List<PmsAlbumPic> selectByExample(PmsAlbumPicExample example);

    PmsAlbumPic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") PmsAlbumPic row, @Param("example") PmsAlbumPicExample example);

    int updateByExample(@Param("row") PmsAlbumPic row, @Param("example") PmsAlbumPicExample example);

    int updateByPrimaryKeySelective(PmsAlbumPic row);

    int updateByPrimaryKey(PmsAlbumPic row);
}