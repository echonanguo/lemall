package org.nanguo.lemall.business.admin.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.nanguo.lemall.business.admin.product.dto.response.PmsBrandResponseDTO;
import org.nanguo.lemall.business.admin.product.service.PmsBrandService;
import org.nanguo.lemall.util.response.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/lemall-admin/product/brand")
public class PmsBrandController {

    private final PmsBrandService brandService;

    @Operation(summary = "根据品牌名称分页获取品牌列表")
    @GetMapping("/list")
    public Result<IPage<PmsBrandResponseDTO>> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        IPage<PmsBrandResponseDTO> res =  brandService.getList(keyword,pageNum,pageSize);
        return Result.success(res);
    }

    @Operation(summary = "获取全部品牌列表")
    @GetMapping("/listAll")
    public Result<List<PmsBrandResponseDTO>> getListAll() {
        List<PmsBrandResponseDTO> brandResponseDTOS = brandService.getListAll();
        return Result.success(brandResponseDTOS);
    }
}
