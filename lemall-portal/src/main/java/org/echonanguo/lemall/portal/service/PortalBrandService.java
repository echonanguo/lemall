package org.echonanguo.lemall.portal.service;

import org.echonanguo.lemall.common.api.CommonPage;
import org.echonanguo.lemall.mbg.model.PmsBrand;
import org.echonanguo.lemall.mbg.model.PmsProduct;

import java.util.List;

/**
 * 前台品牌管理Service
 * Created by echonanguo on 2025/4/26.
 */
public interface PortalBrandService {
    /**
     * 分页获取推荐品牌
     */
    List<PmsBrand> recommendList(Integer pageNum, Integer pageSize);

    /**
     * 获取品牌详情
     */
    PmsBrand detail(Long brandId);

    /**
     * 分页获取品牌关联商品
     */
    CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize);
}
