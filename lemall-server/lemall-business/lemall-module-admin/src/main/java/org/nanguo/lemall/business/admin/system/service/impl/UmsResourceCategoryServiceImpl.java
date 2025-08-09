package org.nanguo.lemall.business.admin.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.nanguo.lemall.business.admin.system.dto.response.UmsResourceCategoryResponseDTO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.nanguo.lemall.business.admin.system.entity.UmsResourceCategory;
import org.nanguo.lemall.business.admin.system.mapper.UmsResourceCategoryMapper;
import org.nanguo.lemall.business.admin.system.service.UmsResourceCategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UmsResourceCategoryServiceImpl extends ServiceImpl<UmsResourceCategoryMapper, UmsResourceCategory> implements UmsResourceCategoryService {

    @Override
    public List<UmsResourceCategoryResponseDTO> listAllResourceCategory() {
        return super.list(Wrappers.<UmsResourceCategory>lambdaQuery().orderByDesc(UmsResourceCategory::getSort).orderByDesc(UmsResourceCategory::getCreateTime)).stream().map(e -> {
            UmsResourceCategoryResponseDTO dto = new UmsResourceCategoryResponseDTO();
            dto.setId(e.getId());
            dto.setName(e.getName());
            return dto;
        }).collect(Collectors.toList());
    }
}
