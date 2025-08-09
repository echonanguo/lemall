package org.nanguo.lemall.business.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.nanguo.lemall.auth.constant.AuthConstant;
import org.nanguo.lemall.business.admin.system.dto.response.UmsResourceResponseDTO;
import org.nanguo.lemall.business.admin.system.entity.UmsResource;
import org.nanguo.lemall.business.admin.system.mapper.UmsResourceMapper;
import org.nanguo.lemall.business.admin.system.service.UmsResourceService;
import org.nanguo.lemall.service.RedisService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 后台资源管理Service实现类
 */
@Service
@RequiredArgsConstructor
public class UmsResourceServiceImpl extends ServiceImpl<UmsResourceMapper, UmsResource> implements UmsResourceService{

    private final RedisService redisService;
    private final UmsResourceMapper umsResourceMapper;
    @Value("${lemall.server.prefix.admin}")
    private String adminPrefix;

    @Override
    public void initPathResourceMap() {
        Map<String,String> pathResourceMap = new TreeMap<>();
        List<UmsResource> resourceList = umsResourceMapper.selectList(null);
        for (UmsResource resource : resourceList) {
            pathResourceMap.put("/"+adminPrefix+resource.getUrl(),resource.getId()+":"+resource.getName());
        }
        redisService.del(AuthConstant.PATH_RESOURCE_MAP);
        redisService.hSetAll(AuthConstant.PATH_RESOURCE_MAP, pathResourceMap);
    }

    @Override
    public List<UmsResourceResponseDTO> listAll() {
        return super.list().stream().map(e -> {
            UmsResourceResponseDTO umsResourceResponseDTO = new UmsResourceResponseDTO();
            BeanUtils.copyProperties(e, umsResourceResponseDTO);
            return umsResourceResponseDTO;
        }).collect(Collectors.toList());
    }
}
