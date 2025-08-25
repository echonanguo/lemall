package org.nanguo.lemall.business.admin.content.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.nanguo.lemall.business.admin.content.dto.response.CmsPrefrenceAreaResponseDTO;
import org.nanguo.lemall.business.admin.content.service.CmsPrefrenceAreaService;
import org.nanguo.lemall.util.response.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/lemall-admin/content/prefrenceArea")
@Tag(name = "商品优选管理", description = "CmsPrefrenceAreaController")
public class CmsPrefrenceAreaController {

    private final CmsPrefrenceAreaService cmsPrefrenceAreaService;

    @Operation(summary = "获取所有商品优选")
    @GetMapping("/listAll")
    public Result<List<CmsPrefrenceAreaResponseDTO>> listAll() {
        List<CmsPrefrenceAreaResponseDTO> responseDTO = cmsPrefrenceAreaService.listAll();
        return Result.success(responseDTO);
    }
}
