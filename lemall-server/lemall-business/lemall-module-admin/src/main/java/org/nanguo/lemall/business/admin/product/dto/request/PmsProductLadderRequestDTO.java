package org.nanguo.lemall.business.admin.product.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Schema(name = "商品阶梯价格请求DTO")
public class PmsProductLadderRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @Schema(description = "商品id")
    private Long productId;

    @Schema(description = "满足的商品数量")
    private Integer count;

    @Schema(description = "折扣（如 0.8 表示 8 折）")
    private BigDecimal discount;

    @Schema(description = "折后价格")
    private BigDecimal price;
}
