package org.echonanguo.lemall.dto;

import org.echonanguo.lemall.model.OmsCompanyAddress;
import org.echonanguo.lemall.model.OmsOrderReturnApply;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 申请信息封装
 * Created by echonanguo on 2025/10/18.
 */
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {
    @Getter
    @Setter
    @Schema(title = "公司收货地址")
    private OmsCompanyAddress companyAddress;
}
