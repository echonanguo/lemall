package org.nanguo.lemall.business.admin.system.service;

import org.nanguo.lemall.business.admin.system.dto.response.UmsResourceCategoryResponseDTO;
import org.nanguo.lemall.business.admin.system.entity.UmsResourceCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UmsResourceCategoryService extends IService<UmsResourceCategory>{


    /**
     * 列出所有资源分类
     * @return 资源分类列表
     */
    List<UmsResourceCategoryResponseDTO> listAllResourceCategory();
}
