package org.nanguo.lemall.business.admin.system.service;


import org.nanguo.lemall.business.admin.system.dto.response.UmsResourceResponseDTO;

import java.util.List;
import java.util.Map;

/**
 * 后台资源管理Service
 */
public interface UmsResourceService {

    /**
     * 初始化路径与资源访问规则
     */
    void initPathResourceMap();

    /**
     * 列出所有资源
     * @return 资源列表
     */
    List<UmsResourceResponseDTO> listAll();
}
