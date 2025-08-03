package org.nanguo.lemall.business.admin.system.service.impl;

import lombok.RequiredArgsConstructor;
import org.nanguo.lemall.auth.constant.AuthConstant;
import org.nanguo.lemall.business.admin.system.entity.UmsResource;
import org.nanguo.lemall.business.admin.system.mapper.UmsResourceMapper;
import org.nanguo.lemall.business.admin.system.service.UmsResourceService;
import org.nanguo.lemall.service.RedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 后台资源管理Service实现类
 */
@Service
@RequiredArgsConstructor
public class UmsResourceServiceImpl implements UmsResourceService {
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
}
