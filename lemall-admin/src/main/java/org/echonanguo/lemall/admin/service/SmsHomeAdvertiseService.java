package org.echonanguo.lemall.admin.service;

import org.echonanguo.lemall.mbg.model.SmsHomeAdvertise;

import java.util.List;

/**
 * 首页广告管理Service
 * Created by echonanguo on 2025/4/26.
 */
public interface SmsHomeAdvertiseService {
    /**
     * 添加广告
     */
    int create(SmsHomeAdvertise advertise);

    /**
     * 批量删除广告
     */
    int delete(List<Long> ids);

    /**
     * 修改上、下线状态
     */
    int updateStatus(Long id, Integer status);

    /**
     * 获取广告详情
     */
    SmsHomeAdvertise getItem(Long id);

    /**
     * 更新广告
     */
    int update(Long id, SmsHomeAdvertise advertise);

    /**
     * 分页查询广告
     */
    List<SmsHomeAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum);
}
