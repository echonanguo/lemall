package org.nanguo.lemall.business.admin.product.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.nanguo.lemall.business.admin.product.dto.request.PmsProductQueryParamRequestDTO;
import org.nanguo.lemall.business.admin.product.dto.response.PmsProductResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.nanguo.lemall.business.admin.product.mapper.PmsProductMapper;
import org.nanguo.lemall.business.admin.product.entity.PmsProduct;
import org.nanguo.lemall.business.admin.product.service.PmsProductService;
import org.springframework.util.StringUtils;

@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements PmsProductService{

    @Override
    public IPage<PmsProductResponseDTO> getList(PmsProductQueryParamRequestDTO productQueryParam, Integer pageSize, Integer pageNum) {
        return super.page(new Page<>(pageNum, pageSize), Wrappers.<PmsProduct>lambdaQuery()
                .eq(productQueryParam.getPublishStatus() != null,PmsProduct::getPublishStatus,productQueryParam.getPublishStatus())
                .eq(productQueryParam.getVerifyStatus() != null,PmsProduct::getVerifyStatus,productQueryParam.getVerifyStatus())
                .like(StringUtils.hasText(productQueryParam.getKeyword()),PmsProduct::getKeywords,productQueryParam.getKeyword())
                .eq(StringUtils.hasText(productQueryParam.getProductSn()),PmsProduct::getProductSn,productQueryParam.getProductSn())
                .eq(productQueryParam.getProductCategoryId() != null,PmsProduct::getProductCategoryId,productQueryParam.getProductCategoryId())
                .eq(productQueryParam.getBrandId() != null,PmsProduct::getBrandId,productQueryParam.getBrandId())
        ).convert(e -> {
            PmsProductResponseDTO responseDTO = new PmsProductResponseDTO();
            BeanUtils.copyProperties(e, responseDTO);
            return responseDTO;
        });
    }
}
