package org.nanguo.lemall.business.admin.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.nanguo.lemall.business.admin.product.dto.request.PmsProductQueryParamRequestDTO;
import org.nanguo.lemall.business.admin.product.dto.response.PmsProductResponseDTO;
import org.nanguo.lemall.business.admin.product.service.PmsProductService;
import org.nanguo.lemall.util.response.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
