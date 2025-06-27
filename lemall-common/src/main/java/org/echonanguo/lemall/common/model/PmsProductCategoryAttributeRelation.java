package org.echonanguo.lemall.common.model;

/**
    * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）
    */
public class PmsProductCategoryAttributeRelation {
    private Long id;

    private Long productCategoryId;

    private Long productAttributeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getProductAttributeId() {
        return productAttributeId;
    }

    public void setProductAttributeId(Long productAttributeId) {
        this.productAttributeId = productAttributeId;
    }
}