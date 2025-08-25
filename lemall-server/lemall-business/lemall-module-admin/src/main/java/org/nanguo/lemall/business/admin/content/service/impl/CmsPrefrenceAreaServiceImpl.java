package org.nanguo.lemall.business.admin.content.service.impl;

import org.nanguo.lemall.business.admin.content.dto.response.CmsPrefrenceAreaResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.nanguo.lemall.business.admin.content.mapper.CmsPrefrenceAreaMapper;
import org.nanguo.lemall.business.admin.content.entity.CmsPrefrenceArea;
import org.nanguo.lemall.business.admin.content.service.CmsPrefrenceAreaService;

import java.util.List;

@Service
public class CmsPrefrenceAreaServiceImpl extends ServiceImpl<CmsPrefrenceAreaMapper, CmsPrefrenceArea> implements CmsPrefrenceAreaService{

    @Override
    public List<CmsPrefrenceAreaResponseDTO> listAll() {
        return super.list().stream().map(e -> {
            CmsPrefrenceAreaResponseDTO dto = new CmsPrefrenceAreaResponseDTO();
            BeanUtils.copyProperties(e,dto);
            return dto;
        }).toList();
    }
}
