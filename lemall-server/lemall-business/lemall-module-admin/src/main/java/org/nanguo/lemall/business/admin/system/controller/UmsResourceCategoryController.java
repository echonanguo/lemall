package org.nanguo.lemall.business.admin.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.nanguo.lemall.business.admin.system.dto.response.UmsResourceCategoryResponseDTO;
import org.nanguo.lemall.business.admin.system.service.UmsResourceCategoryService;
import org.nanguo.lemall.util.response.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/lemall-admin/system/resourceCategory")
@Tag(name = "资源分类管理")
public class UmsResourceCategoryController {

    private final UmsResourceCategoryService umsResourceCategoryService;

    @Operation(summary = "查询所有后台资源分类")
    @GetMapping("/listAll")
    public Result<List<UmsResourceCategoryResponseDTO>> listAllResourceCategory() {
        List<UmsResourceCategoryResponseDTO> umsResourceCategoryResponseDTOS = umsResourceCategoryService.listAllResourceCategory();
        return Result.success(umsResourceCategoryResponseDTOS);
    }
 }
