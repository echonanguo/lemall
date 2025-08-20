package org.nanguo.lemall.business.admin.product.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.nanguo.lemall.business.admin.product.dto.response.PmsBrandResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.nanguo.lemall.business.admin.product.mapper.PmsBrandMapper;
import org.nanguo.lemall.business.admin.product.entity.PmsBrand;
import org.nanguo.lemall.business.admin.product.service.PmsBrandService;
import org.springframework.util.StringUtils;

@Service
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements PmsBrandService{

    @Override
    public IPage<PmsBrandResponseDTO> getList(String keyword, Integer pageNum, Integer pageSize) {
        return super.page(new Page<>(pageNum,pageSize), Wrappers.<PmsBrand>lambdaQuery()
                .like(StringUtils.hasText(keyword),PmsBrand::getName, keyword)
                .orderByDesc(PmsBrand::getSort)
        ).convert(e -> {
            PmsBrandResponseDTO pmsBrandResponseDTO = new PmsBrandResponseDTO();
            BeanUtils.copyProperties(e,pmsBrandResponseDTO);
            return pmsBrandResponseDTO;
        });
    }
}
