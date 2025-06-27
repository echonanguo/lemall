package org.echonanguo.lemall.common.model;

/**
    * 优选专区和产品关系表
    */
public class CmsPrefrenceAreaProductRelation {
    private Long id;

    private Long prefrenceAreaId;

    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrefrenceAreaId() {
        return prefrenceAreaId;
    }

    public void setPrefrenceAreaId(Long prefrenceAreaId) {
        this.prefrenceAreaId = prefrenceAreaId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}