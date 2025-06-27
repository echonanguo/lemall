package org.echonanguo.lemall.admin.service;

import jakarta.servlet.http.HttpServletRequest;
import org.echonanguo.lemall.admin.dto.OssCallbackResult;
import org.echonanguo.lemall.admin.dto.OssPolicyResult;

/**
 * oss上传管理Service
 * Created by echonanguo on 2025/4/26.
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
