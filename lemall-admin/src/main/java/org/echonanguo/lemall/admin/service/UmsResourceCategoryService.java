package org.echonanguo.lemall.admin.service;

import org.echonanguo.lemall.mbg.model.UmsResourceCategory;

import java.util.List;

/**
 * 后台资源分类管理Service
 * Created by echonanguo on 2025/4/22.
 */
public interface UmsResourceCategoryService {

    /**
     * 获取所有资源分类
     */
    List<UmsResourceCategory> listAll();

    /**
     * 创建资源分类
     */
    int create(UmsResourceCategory umsResourceCategory);

    /**
     * 修改资源分类
     */
    int update(Long id, UmsResourceCategory umsResourceCategory);

    /**
     * 删除资源分类
     */
    int delete(Long id);
}
