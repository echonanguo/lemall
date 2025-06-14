package org.echonanguo.lemall.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 查询单个产品进行修改时返回的结果
 * Created by echonanguo on 2025/4/26.
 */
public class PmsProductResult extends PmsProductParam {
    @Getter
    @Setter
    @Schema(title = "商品所选分类的父id")
    private Long cateParentId;
}
