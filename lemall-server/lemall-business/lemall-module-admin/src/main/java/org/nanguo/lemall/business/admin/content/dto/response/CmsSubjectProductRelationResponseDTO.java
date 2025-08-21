package org.nanguo.lemall.business.admin.content.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Schema(name = "专题商品关系响应DTO")
public class CmsSubjectProductRelationResponseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @Schema(description = "专题ID")
    private Long subjectId;

    @Schema(description = "商品ID")
    private Long productId;
}

