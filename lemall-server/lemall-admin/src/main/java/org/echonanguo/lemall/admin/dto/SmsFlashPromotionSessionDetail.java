package org.echonanguo.lemall.admin.dto;

import org.echonanguo.lemall.mbg.model.SmsFlashPromotionSession;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 包含商品数量的场次信息
 * Created by echonanguo on 2025/4/26.
 */
public class SmsFlashPromotionSessionDetail extends SmsFlashPromotionSession {
    @Setter
    @Getter
    @Schema(title = "商品数量")
    private Long productCount;
}
