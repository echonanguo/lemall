package org.nanguo.lemall.business.admin.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.nanguo.lemall.business.admin.product.dto.request.PmsProductQueryParamRequestDTO;
import org.nanguo.lemall.business.admin.product.dto.request.PmsProductParamRequestDTO;
import org.nanguo.lemall.business.admin.product.dto.response.PmsProductParamResponseDTO;
import org.nanguo.lemall.business.admin.product.dto.response.PmsProductParamResultResponseDTO;
import org.nanguo.lemall.business.admin.product.dto.response.PmsProductResponseDTO;
import org.nanguo.lemall.business.admin.product.service.PmsProductService;
import org.nanguo.lemall.util.response.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/lemall-admin/product/product")
@Tag(name = "商品管理",description = "PmsProductController")
public class PmsProductController {

    private final PmsProductService pmsProductService;

    @Operation(summary = "查询商品")
    @GetMapping("/list")
    public Result<IPage<PmsProductResponseDTO>> getList(PmsProductQueryParamRequestDTO productQueryParam,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        IPage<PmsProductResponseDTO> res = pmsProductService.getList(productQueryParam,pageSize,pageNum);
        return Result.success(res);
    }

    @Operation(summary = "创建商品")
    @PostMapping("/create")
    public Result<?> create(@Validated @RequestBody PmsProductParamRequestDTO requestDTO) {
        boolean flag = pmsProductService.create(requestDTO);
        return flag ? Result.success() : Result.fail("创建商品失败");
    }

    @Operation(summary = "根据商品id获取商品编辑信息")
    @GetMapping("/updateInfo/{id}")
    public Result<PmsProductParamResultResponseDTO> updateInfo(@PathVariable("id") Long id) {
        PmsProductParamResultResponseDTO res = pmsProductService.getUpdateInfo(id);
        return Result.success(res);
    }
}
