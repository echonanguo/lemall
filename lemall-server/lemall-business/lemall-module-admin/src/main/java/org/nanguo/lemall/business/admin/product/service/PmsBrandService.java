package org.nanguo.lemall.business.admin.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.nanguo.lemall.business.admin.product.dto.request.PmsBrandRequestDTO;
import org.nanguo.lemall.business.admin.product.dto.response.PmsBrandResponseDTO;
import org.nanguo.lemall.business.admin.product.entity.PmsBrand;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PmsBrandService extends IService<PmsBrand>{


    /**
     * 分页查询品牌列表
     * @param keyword 关键词
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @return 结果
     */
    IPage<PmsBrandResponseDTO> getList(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 获取所有品牌
     * @return 结果
     */
    List<PmsBrandResponseDTO> getListAll();

    /**
     * 添加品牌
     * @param requestDTO 请求参数
     * @return 成功标志
     */
    boolean create(PmsBrandRequestDTO requestDTO);

    /**
     * 更新品牌
     * @param id id
     * @param requestDTO 请求参数
     * @return 成功标志
     */
    @Transactional(rollbackFor = Exception.class)
    boolean updateBrand(Long id, PmsBrandRequestDTO requestDTO);

    /**
     * 删除品牌
     * @param id id
     * @return 成功标志
     */
    boolean deleteBrandById(Long id);
}
