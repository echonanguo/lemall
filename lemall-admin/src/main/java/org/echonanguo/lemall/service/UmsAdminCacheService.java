package org.echonanguo.lemall.service;

import org.echonanguo.lemall.model.UmsAdmin;
import org.echonanguo.lemall.model.UmsResource;

/**
 * 后台用户缓存操作类
 * Created by echonanguo on 2020/3/13.
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
