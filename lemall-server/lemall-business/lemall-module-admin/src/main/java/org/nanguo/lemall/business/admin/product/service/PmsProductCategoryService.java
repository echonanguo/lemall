package org.nanguo.lemall.business.admin.product.service;

import org.nanguo.lemall.business.admin.product.dto.response.PmsProductCategoryWithChildrenItem;
import org.nanguo.lemall.business.admin.product.entity.PmsProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface PmsProductCategoryService extends IService<PmsProductCategory>{


    /**
     * 查询所有一级分类及子分类
     * @return 结果
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
