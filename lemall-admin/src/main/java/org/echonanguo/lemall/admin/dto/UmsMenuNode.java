package org.echonanguo.lemall.admin.dto;

import org.echonanguo.lemall.mbg.model.UmsMenu;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 后台菜单节点封装
 * Created by echonanguo on 2025/4/22.
 */
@Getter
@Setter
public class UmsMenuNode extends UmsMenu {
    @Schema(title = "子级菜单")
    private List<UmsMenuNode> children;
}
