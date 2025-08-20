package org.nanguo.lemall.business.admin.product.service.impl;

import org.nanguo.lemall.business.admin.product.dto.response.PmsProductCategoryWithChildrenItem;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.nanguo.lemall.business.admin.product.mapper.PmsProductCategoryMapper;
import org.nanguo.lemall.business.admin.product.entity.PmsProductCategory;
import org.nanguo.lemall.business.admin.product.service.PmsProductCategoryService;

import java.util.List;

@Service
public class PmsProductCategoryServiceImpl extends ServiceImpl<PmsProductCategoryMapper, PmsProductCategory> implements PmsProductCategoryService{

    @Override
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return baseMapper.listWithChildren();
    }
}
