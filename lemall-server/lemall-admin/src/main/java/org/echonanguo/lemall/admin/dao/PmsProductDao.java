package org.echonanguo.lemall.admin.dao;

import org.echonanguo.lemall.admin.dto.PmsProductResult;
import org.apache.ibatis.annotations.Param;


/**
 * 自定义商品管理Dao
 * Created by echonanguo on 2025/4/26.
 */
public interface PmsProductDao {
    /**
     * 获取商品编辑信息
     */
    PmsProductResult getUpdateInfo(@Param("id") Long id);
}
