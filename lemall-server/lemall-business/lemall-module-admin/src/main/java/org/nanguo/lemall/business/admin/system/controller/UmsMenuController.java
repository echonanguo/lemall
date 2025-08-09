package org.nanguo.lemall.business.admin.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.nanguo.lemall.business.admin.system.dto.response.UmsMenuNodeResponseDTO;
import org.nanguo.lemall.business.admin.system.dto.response.UmsMenuResponseDTO;
import org.nanguo.lemall.business.admin.system.service.UmsMenuService;
import org.nanguo.lemall.util.response.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/lemall-admin/system/menu")
@Tag(name = "菜单管理", description = "UmsMenuController")
public class UmsMenuController {

    private final UmsMenuService umsMenuService;

    @Operation(summary = "树形结构返回所有菜单列表")
    @GetMapping("/treeList")
    public Result<List<UmsMenuNodeResponseDTO>> treeList() {
        List<UmsMenuNodeResponseDTO> umsMenuNodeResponseDTO = umsMenuService.treeList();
        return Result.success(umsMenuNodeResponseDTO);
    }

    @Operation(summary = "分页查询后台菜单")
    @GetMapping("/list/{parentId}")
    public Result<IPage<UmsMenuResponseDTO>> list(@PathVariable @NotNull Long parentId,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        IPage<UmsMenuResponseDTO> menuResponseDTOIPage = umsMenuService.pageMenu(parentId, pageNum, pageSize);
        return Result.success(menuResponseDTOIPage);
    }


}
