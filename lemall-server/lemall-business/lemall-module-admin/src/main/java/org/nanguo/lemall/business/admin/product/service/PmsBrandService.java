package org.nanguo.lemall.business.admin.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.nanguo.lemall.business.admin.product.dto.response.PmsBrandResponseDTO;
import org.nanguo.lemall.business.admin.product.entity.PmsBrand;
import com.baomidou.mybatisplus.extension.service.IService;
public interface PmsBrandService extends IService<PmsBrand>{


    /**
     * 分页查询品牌列表
     * @param keyword 关键词
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @return 结果
     */
    IPage<PmsBrandResponseDTO> getList(String keyword, Integer pageNum, Integer pageSize);
}
