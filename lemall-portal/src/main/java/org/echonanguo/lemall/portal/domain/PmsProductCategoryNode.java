package org.echonanguo.lemall.portal.domain;

import lombok.Getter;
import lombok.Setter;
import org.echonanguo.lemall.mbg.model.PmsProductCategory;

import java.util.List;

/**
 * 商品分类，包含子分类
 * Created by echonanguo on 2025/4/22.
 */
@Getter
@Setter
public class PmsProductCategoryNode extends PmsProductCategory {
    private List<PmsProductCategoryNode> children;
}
