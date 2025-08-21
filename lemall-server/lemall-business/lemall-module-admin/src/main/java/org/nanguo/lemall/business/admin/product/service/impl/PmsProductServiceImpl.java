package org.nanguo.lemall.business.admin.product.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.nanguo.lemall.business.admin.content.entity.CmsPrefrenceAreaProductRelation;
import org.nanguo.lemall.business.admin.content.entity.CmsSubjectProductRelation;
import org.nanguo.lemall.business.admin.content.service.CmsPrefrenceAreaProductRelationService;
import org.nanguo.lemall.business.admin.content.service.CmsSubjectProductRelationService;
import org.nanguo.lemall.business.admin.product.dto.request.PmsProductQueryParamRequestDTO;
import org.nanguo.lemall.business.admin.product.dto.request.PmsProductRequestDTO;
import org.nanguo.lemall.business.admin.product.dto.response.PmsProductResponseDTO;
import org.nanguo.lemall.business.admin.product.entity.*;
import org.nanguo.lemall.business.admin.product.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.nanguo.lemall.business.admin.product.mapper.PmsProductMapper;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements PmsProductService{

    private final PmsMemberPriceService pmsMemberPriceService;
    private final PmsProductLadderService pmsProductLadderService;
    private final PmsProductFullReductionService pmsProductFullReductionService;
    private final PmsSkuStockService pmsSkuStockService;
    private final PmsProductAttributeValueService pmsProductAttributeValueService;
    private final CmsSubjectProductRelationService cmsSubjectProductRelationService;
    private final CmsPrefrenceAreaProductRelationService cmsPrefrenceAreaProductRelationService;

    @Override
    public IPage<PmsProductResponseDTO> getList(PmsProductQueryParamRequestDTO productQueryParam, Integer pageSize, Integer pageNum) {
        return super.page(new Page<>(pageNum, pageSize), Wrappers.<PmsProduct>lambdaQuery()
                .eq(productQueryParam.getPublishStatus() != null,PmsProduct::getPublishStatus,productQueryParam.getPublishStatus())
                .eq(productQueryParam.getVerifyStatus() != null,PmsProduct::getVerifyStatus,productQueryParam.getVerifyStatus())
                .like(StringUtils.hasText(productQueryParam.getKeyword()),PmsProduct::getKeywords,productQueryParam.getKeyword())
                .eq(StringUtils.hasText(productQueryParam.getProductSn()),PmsProduct::getProductSn,productQueryParam.getProductSn())
                .eq(productQueryParam.getProductCategoryId() != null,PmsProduct::getProductCategoryId,productQueryParam.getProductCategoryId())
                .eq(productQueryParam.getBrandId() != null,PmsProduct::getBrandId,productQueryParam.getBrandId())
                .orderByDesc(PmsProduct::getSort)
        ).convert(e -> {
            PmsProductResponseDTO responseDTO = new PmsProductResponseDTO();
            BeanUtils.copyProperties(e, responseDTO);
            return responseDTO;
        });
    }

    @Override
    public boolean create(PmsProductRequestDTO requestDTO) {
        // 1. 创建商品
        requestDTO.setId(null);
        PmsProduct pmsProduct = new PmsProduct();
        BeanUtils.copyProperties(requestDTO, pmsProduct);
        super.save(pmsProduct);

        // 2.根据促销类型设置加个：会员价格，阶梯价格，满减价格
        Long id = pmsProduct.getId();
        // 会员价格
        List<PmsMemberPrice> memberPrices = requestDTO.getMemberPriceList().stream().map(e -> {
            PmsMemberPrice pmsMemberPrice = new PmsMemberPrice();
            BeanUtils.copyProperties(e, pmsMemberPrice);
            pmsMemberPrice.setProductId(id);
            return pmsMemberPrice;
        }).toList();
        pmsMemberPriceService.saveBatch(memberPrices);
        // 阶梯价格
        List<PmsProductLadder> pmsProductLadders = requestDTO.getProductLadderList().stream().map(e -> {
            PmsProductLadder productLadder = new PmsProductLadder();
            BeanUtils.copyProperties(e, productLadder);
            productLadder.setProductId(id);
            return productLadder;
        }).toList();
        pmsProductLadderService.saveBatch(pmsProductLadders);
        // 满减价格
        List<PmsProductFullReduction> pmsProductFullReductions = requestDTO.getProductFullReductionList().stream().map(e -> {
            PmsProductFullReduction pmsProductFullReduction = new PmsProductFullReduction();
            BeanUtils.copyProperties(e, pmsProductFullReduction);
            pmsProductFullReduction.setProductId(id);
            return pmsProductFullReduction;
        }).toList();
        pmsProductFullReductionService.saveBatch(pmsProductFullReductions);
        // 获取po并处理sku的编码
        List<PmsSkuStock> pmsSkuStocks = requestDTO.getSkuStockList().stream().map(e -> {
            PmsSkuStock pmsSkuStock = new PmsSkuStock();
            BeanUtils.copyProperties(e, pmsSkuStock);
            pmsSkuStock.setProductId(id);
            return pmsSkuStock;
        }).toList();
        handleSkuStockCode(pmsSkuStocks,id);
        // 添加sku库存信息
        pmsSkuStockService.saveBatch(pmsSkuStocks);
        // 添加商品参数，添加自定义商品规格
        List<PmsProductAttributeValue> pmsProductAttributeValues = requestDTO.getProductAttributeValueList().stream().map(e -> {
            PmsProductAttributeValue pmsProductAttributeValue = new PmsProductAttributeValue();
            BeanUtils.copyProperties(e, pmsProductAttributeValue);
            pmsProductAttributeValue.setProductId(id);
            return pmsProductAttributeValue;
        }).toList();
        pmsProductAttributeValueService.saveBatch(pmsProductAttributeValues);
        // 关联专题
        List<CmsSubjectProductRelation> cmsSubjectProductRelations = requestDTO.getSubjectProductRelationList().stream().map(e -> {
            CmsSubjectProductRelation cmsSubjectProductRelation = new CmsSubjectProductRelation();
            BeanUtils.copyProperties(e, cmsSubjectProductRelation);
            cmsSubjectProductRelation.setProductId(id);
            return cmsSubjectProductRelation;
        }).toList();
        cmsSubjectProductRelationService.saveBatch(cmsSubjectProductRelations);
        // 关联优选
        List<CmsPrefrenceAreaProductRelation> cmsPrefrenceAreaProductRelations = requestDTO.getPrefrenceAreaProductRelationList().stream().map(e -> {
            CmsPrefrenceAreaProductRelation cmsPrefrenceAreaProductRelation = new CmsPrefrenceAreaProductRelation();
            BeanUtils.copyProperties(e, cmsPrefrenceAreaProductRelation);
            cmsPrefrenceAreaProductRelation.setProductId(id);
            return cmsPrefrenceAreaProductRelation;
        }).toList();
        cmsPrefrenceAreaProductRelationService.saveBatch(cmsPrefrenceAreaProductRelations);
        return true;
    }

    private void handleSkuStockCode(List<PmsSkuStock> skuStockList, Long productId) {
        if(CollectionUtils.isEmpty(skuStockList))return;
        for(int i=0;i<skuStockList.size();i++){
            PmsSkuStock skuStock = skuStockList.get(i);
            if(!StringUtils.hasText(skuStock.getSkuCode())){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                //日期
                String sb = sdf.format(new Date()) +
                        //四位商品id
                        String.format("%04d", productId) +
                        //三位索引id
                        String.format("%03d", i + 1);
                skuStock.setSkuCode(sb);
            }
        }
    }
}
