package org.echonanguo.lemall.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.echonanguo.lemall.admin.service.UmsResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.echonanguo.lemall.admin.mapper.UmsResourceCategoryMapper;
import org.echonanguo.lemall.common.model.UmsResourceCategory;

import java.util.Date;
import java.util.List;

@Service
public class UmsResourceCategoryServiceImpl extends ServiceImpl<UmsResourceCategoryMapper, UmsResourceCategory> implements UmsResourceCategoryService {

    @Override
    public List<UmsResourceCategory> listAll() {
        return baseMapper.selectList(
                Wrappers.<UmsResourceCategory>lambdaQuery()
                        .orderByDesc(UmsResourceCategory::getSort)
        );
    }

    @Override
    public int create(UmsResourceCategory umsResourceCategory) {
        umsResourceCategory.setCreateTime(new Date());
        return baseMapper.insert(umsResourceCategory);
    }

    @Override
    public int update(Long id, UmsResourceCategory umsResourceCategory) {
        umsResourceCategory.setId(id);
        return baseMapper.updateById(umsResourceCategory);
    }

    @Override
    public int delete(Long id) {
        return baseMapper.deleteById(id);
    }
}
