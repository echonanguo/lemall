package org.echonanguo.lemall.admin.service;

import org.echonanguo.lemall.mbg.model.UmsAdmin;

/**
 * 后台用户缓存操作类
 * Created by echonanguo on 2025/4/22.
 */
public interface UmsAdminCacheService {
    /**
     * 删除后台用户缓存
     */
    void delAdmin(Long adminId);

    /**
     * 获取缓存后台用户信息
     */
    UmsAdmin getAdmin(Long adminId);

    /**
     * 设置缓存后台用户信息
     */
    void setAdmin(UmsAdmin admin);
}
