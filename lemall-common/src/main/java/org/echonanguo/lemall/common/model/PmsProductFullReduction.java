package org.echonanguo.lemall.common.model;

import java.math.BigDecimal;

/**
    * 产品满减表(只针对同商品)
    */
public class PmsProductFullReduction {
    private Long id;

    private Long productId;

    private BigDecimal fullPrice;

    private BigDecimal reducePrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(BigDecimal fullPrice) {
        this.fullPrice = fullPrice;
    }

    public BigDecimal getReducePrice() {
        return reducePrice;
    }

    public void setReducePrice(BigDecimal reducePrice) {
        this.reducePrice = reducePrice;
    }
}