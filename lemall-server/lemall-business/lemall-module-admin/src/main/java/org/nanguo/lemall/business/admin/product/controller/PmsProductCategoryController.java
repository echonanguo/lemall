package org.nanguo.lemall.business.admin.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.nanguo.lemall.business.admin.product.dto.response.PmsProductCategoryWithChildrenItem;
import org.nanguo.lemall.business.admin.product.service.PmsProductCategoryService;
import org.nanguo.lemall.util.response.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/lemall-admin/product/productCategory")
@Tag(name = "商品分类管理",description = "PmsProductCategoryController")
public class PmsProductCategoryController {

    private final PmsProductCategoryService pmsProductCategoryService;

    @Operation(summary = "查询所有一级分类及子分类")
    @GetMapping("/list/withChildren")
    public Result<List<PmsProductCategoryWithChildrenItem>> listWithChildren() {
        List<PmsProductCategoryWithChildrenItem> list = pmsProductCategoryService.listWithChildren();
        return Result.success(list);
    }
}
