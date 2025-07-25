package org.echonanguo.lemall.admin.dto;

import org.echonanguo.lemall.mbg.model.OmsCompanyAddress;
import org.echonanguo.lemall.mbg.model.OmsOrderReturnApply;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 申请信息封装
 * Created by echonanguo on 2025/4/26.
 */
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {
    @Getter
    @Setter
    @Schema(title = "公司收货地址")
    private OmsCompanyAddress companyAddress;
}
