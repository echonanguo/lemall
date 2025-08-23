package org.nanguo.lemall.business.admin.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.nanguo.lemall.business.admin.product.dto.request.PmsProductQueryParamRequestDTO;
import org.nanguo.lemall.business.admin.product.dto.request.PmsProductParamRequestDTO;
import org.nanguo.lemall.business.admin.product.dto.response.PmsProductParamResponseDTO;
import org.nanguo.lemall.business.admin.product.dto.response.PmsProductParamResultResponseDTO;
import org.nanguo.lemall.business.admin.product.dto.response.PmsProductResponseDTO;
import org.nanguo.lemall.business.admin.product.entity.PmsProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

public interface PmsProductService extends IService<PmsProduct>{


    /**
     * 分页查询商品
     * @param productQueryParam 查询参数
     * @param pageSize 每页条数
     * @param pageNum 页码
     * @return 结果
     */
    IPage<PmsProductResponseDTO> getList(PmsProductQueryParamRequestDTO productQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 创建商品
     * @param requestDTO 请求参数
     * @return 成功标志
     */
    @Transactional(rollbackFor = Exception.class)
    boolean create(PmsProductParamRequestDTO requestDTO);

    /**
     * 根据商品id获取商品编辑信息
     * @param id id
     * @return 结果
     */
    PmsProductParamResultResponseDTO getUpdateInfo(Long id);
}
