package org.echonanguo.lemall.admin.dto;

import org.echonanguo.lemall.mbg.model.PmsProductAttribute;
import org.echonanguo.lemall.mbg.model.PmsProductAttributeCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 包含有分类下属性的dto
 * Created by echonanguo on 2025/4/26.
 */
public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {
    @Getter
    @Setter
    @Schema(title = "商品属性列表")
    private List<PmsProductAttribute> productAttributeList;
}
