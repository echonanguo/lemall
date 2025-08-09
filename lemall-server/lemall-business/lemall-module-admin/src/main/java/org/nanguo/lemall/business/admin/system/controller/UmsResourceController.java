package org.nanguo.lemall.business.admin.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.nanguo.lemall.business.admin.system.dto.response.UmsResourceResponseDTO;
import org.nanguo.lemall.business.admin.system.service.UmsResourceService;
import org.nanguo.lemall.util.response.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/lemall-admin/system/resource")
@Tag(name = "资源管理")
public class UmsResourceController {

    private final UmsResourceService umsResourceService;

    @Operation(summary = "查询所有后台资源")
    @GetMapping("/listAll")
    public Result<List<UmsResourceResponseDTO>> listAll() {
        List<UmsResourceResponseDTO> umsResourceResponseDTOS = umsResourceService.listAll();
        return Result.success(umsResourceResponseDTOS);
    }
}
