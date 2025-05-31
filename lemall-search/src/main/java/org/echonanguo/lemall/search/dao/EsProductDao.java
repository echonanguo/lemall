package org.echonanguo.lemall.search.dao;

import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.search.domain.EsProduct;

import java.util.List;

/*
 * @Description: 搜索商品管理自定义Dao
 * @Author:  echonanguo
 * @date:  2025/6/1 上午12:34
 */
public interface EsProductDao {
    /**
     * 获取指定ID的搜索商品
     */
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
