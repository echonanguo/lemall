package org.echonanguo.lemall.admin.service;

import org.echonanguo.lemall.common.model.UmsResourceCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UmsResourceCategoryService extends IService<UmsResourceCategory>{
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
