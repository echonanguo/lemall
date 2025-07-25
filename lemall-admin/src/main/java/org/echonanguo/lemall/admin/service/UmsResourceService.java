package org.echonanguo.lemall.admin.service;

import org.echonanguo.lemall.mbg.model.UmsResource;

import java.util.List;
import java.util.Map;

/**
 * 后台资源管理Service
 * Created by echonanguo on 2025/4/22.
 */
public interface UmsResourceService {
    /**
     * 添加资源
     */
    int create(UmsResource umsResource);

    /**
     * 修改资源
     */
    int update(Long id, UmsResource umsResource);

    /**
     * 获取资源详情
     */
    UmsResource getItem(Long id);

    /**
     * 删除资源
     */
    int delete(Long id);

    /**
     * 分页查询资源
     */
    List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);

    /**
     * 查询全部资源
     */
    List<UmsResource> listAll();

    /**
     * 初始化路径与资源访问规则
     */
    Map<String,String> initPathResourceMap();
}
