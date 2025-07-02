package org.echonanguo.lemall.admin.service;

import org.echonanguo.lemall.common.model.UmsMemberLevel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 会员等级管理Service
 * Created by echonanguo on 2025/4/26.
 */
public interface UmsMemberLevelService extends IService<UmsMemberLevel>{
    /**
     * 获取所有会员登录
     * @param defaultStatus 是否为默认会员
     */
    List<UmsMemberLevel> list(Integer defaultStatus);

}
