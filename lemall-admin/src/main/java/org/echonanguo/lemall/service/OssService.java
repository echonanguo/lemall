package org.echonanguo.lemall.service;

import org.echonanguo.lemall.dto.OssCallbackResult;
import org.echonanguo.lemall.dto.OssPolicyResult;

import jakarta.servlet.http.HttpServletRequest;

/**
 * oss上传管理Service
 * Created by echonanguo on 2018/5/17.
 */
public interface OssService {
    /**
     * oss上传策略生成
     */
    OssPolicyResult policy();
    /**
     * oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
