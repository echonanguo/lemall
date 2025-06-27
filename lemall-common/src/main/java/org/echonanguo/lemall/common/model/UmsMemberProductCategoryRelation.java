package org.echonanguo.lemall.common.model;

/**
    * 会员与产品分类关系表（用户喜欢的分类）
    */
public class UmsMemberProductCategoryRelation {
    private Long id;

    private Long memberId;

    private Long productCategoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }
}