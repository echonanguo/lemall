package org.echonanguo.lemall.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.echonanguo.lemall.admin.service.UmsResourceService;
import org.echonanguo.lemall.common.constant.AuthConstant;
import org.echonanguo.lemall.common.model.UmsResource;
import org.echonanguo.lemall.common.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.echonanguo.lemall.admin.mapper.UmsResourceMapper;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class UmsResourceServiceImpl extends ServiceImpl<UmsResourceMapper, UmsResource> implements UmsResourceService {
    @Autowired
    private RedisService redisService;
    @Value("${spring.application.name}")
    private String applicationName;
    @Override
    public int create(UmsResource umsResource) {
        umsResource.setCreateTime(new Date());
        int count = baseMapper.insert(umsResource);
        initPathResourceMap();
        return count;
    }

    @Override
    public int update(Long id, UmsResource umsResource) {
        umsResource.setId(id);
        int count = baseMapper.updateById(umsResource);
        initPathResourceMap();
        return count;
    }

    @Override
    public UmsResource getItem(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int delete(Long id) {
        int count = baseMapper.deleteById(id);
        initPathResourceMap();
        return count;
    }

    @Override
    public List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        // 创建分页对象
        Page<UmsResource> page = new Page<>(pageNum, pageSize);

        // 构建查询条件
        LambdaQueryWrapper<UmsResource> queryWrapper = new LambdaQueryWrapper<>();

        if (categoryId != null) {
            queryWrapper.eq(UmsResource::getCategoryId, categoryId);
        }
        if (StrUtil.isNotEmpty(nameKeyword)) {
            queryWrapper.like(UmsResource::getName, nameKeyword);
        }
        if (StrUtil.isNotEmpty(urlKeyword)) {
            queryWrapper.like(UmsResource::getUrl, urlKeyword);
        }

        // 执行分页查询
        return baseMapper.selectPage(page, queryWrapper).getRecords();
    }

    @Override
    public List<UmsResource> listAll() {
        return baseMapper.selectList(null);
    }

    @Override
    public Map<String,String> initPathResourceMap() {
        Map<String,String> pathResourceMap = new TreeMap<>();
        List<UmsResource> resourceList = baseMapper.selectList(null);
        for (UmsResource resource : resourceList) {
            pathResourceMap.put("/"+applicationName+resource.getUrl(),resource.getId()+":"+resource.getName());
        }
        redisService.del(AuthConstant.PATH_RESOURCE_MAP);
        redisService.hSetAll(AuthConstant.PATH_RESOURCE_MAP, pathResourceMap);
        return pathResourceMap;

    }
}
