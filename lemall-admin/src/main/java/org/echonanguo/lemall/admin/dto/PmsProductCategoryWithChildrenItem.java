package org.echonanguo.lemall.admin.dto;

import org.echonanguo.lemall.mbg.model.PmsProductCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by echonanguo on 2025/4/26.
 */
public class PmsProductCategoryWithChildrenItem extends PmsProductCategory {
    @Getter
    @Setter
    @Schema(title = "子级分类")
    private List<PmsProductCategory> children;
}
