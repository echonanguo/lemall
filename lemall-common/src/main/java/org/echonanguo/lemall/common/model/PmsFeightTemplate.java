package org.echonanguo.lemall.common.model;

import java.math.BigDecimal;

/**
    * 运费模版
    */
public class PmsFeightTemplate {
    private Long id;

    private String name;

    /**
    * 计费类型:0->按重量；1->按件数
    */
    private Integer chargeType;

    /**
    * 首重kg
    */
    private BigDecimal firstWeight;

    /**
    * 首费（元）
    */
    private BigDecimal firstFee;

    private BigDecimal continueWeight;

    private BigDecimal continmeFee;

    /**
    * 目的地（省、市）
    */
    private String dest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public BigDecimal getFirstWeight() {
        return firstWeight;
    }

    public void setFirstWeight(BigDecimal firstWeight) {
        this.firstWeight = firstWeight;
    }

    public BigDecimal getFirstFee() {
        return firstFee;
    }

    public void setFirstFee(BigDecimal firstFee) {
        this.firstFee = firstFee;
    }

    public BigDecimal getContinueWeight() {
        return continueWeight;
    }

    public void setContinueWeight(BigDecimal continueWeight) {
        this.continueWeight = continueWeight;
    }

    public BigDecimal getContinmeFee() {
        return continmeFee;
    }

    public void setContinmeFee(BigDecimal continmeFee) {
        this.continmeFee = continmeFee;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }
}