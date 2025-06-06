package org.echonanguo.lemall.search.domain;

import java.util.List;

/*
 * @Description: 搜索商品的品牌名称，分类名称及属性
 * @Author:  echonanguo
 * @date:  2025/6/1 上午12:35
 */
public class EsProductRelatedInfo {
    private List<String> brandNames;
    private List<String> productCategoryNames;
    private List<ProductAttr>   productAttrs;

    public List<String> getBrandNames() {
        return brandNames;
    }

    public void setBrandNames(List<String> brandNames) {
        this.brandNames = brandNames;
    }

    public List<String> getProductCategoryNames() {
        return productCategoryNames;
    }

    public void setProductCategoryNames(List<String> productCategoryNames) {
        this.productCategoryNames = productCategoryNames;
    }

    public List<ProductAttr> getProductAttrs() {
        return productAttrs;
    }

    public void setProductAttrs(List<ProductAttr> productAttrs) {
        this.productAttrs = productAttrs;
    }

    public static class ProductAttr{
        private Long attrId;
        private String attrName;
        private List<String> attrValues;

        public Long getAttrId() {
            return attrId;
        }

        public void setAttrId(Long attrId) {
            this.attrId = attrId;
        }

        public List<String> getAttrValues() {
            return attrValues;
        }

        public void setAttrValues(List<String> attrValues) {
            this.attrValues = attrValues;
        }

        public String getAttrName() {
            return attrName;
        }

        public void setAttrName(String attrName) {
            this.attrName = attrName;
        }
    }
}
