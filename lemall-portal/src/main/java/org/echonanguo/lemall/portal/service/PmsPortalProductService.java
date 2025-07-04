package org.echonanguo.lemall.portal.service;

import org.echonanguo.lemall.mbg.model.PmsProduct;
import org.echonanguo.lemall.portal.domain.PmsPortalProductDetail;
import org.echonanguo.lemall.portal.domain.PmsProductCategoryNode;

import java.util.List;

/**
 * 前台商品管理Service
 * Created by echonanguo on 2025/4/22.
 */
public interface PmsPortalProductService {
    /**
     * 综合搜索商品
     */
    List<PmsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort);

    /**
     * 以树形结构获取所有商品分类
     */
    List<PmsProductCategoryNode> categoryTreeList();

    /**
     * 获取前台商品详情
     */
    PmsPortalProductDetail detail(Long id);
}
