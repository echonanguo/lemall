package org.echonanguo.lemall.admin.service;

import org.echonanguo.lemall.mbg.model.CmsSubject;

import java.util.List;

/**
 * 商品专题管理Service
 * Created by echonanguo on 2025/4/22.
 */
public interface CmsSubjectService {
    /**
     * 查询所有专题
     */
    List<CmsSubject> listAll();

    /**
     * 分页查询专题
     */
    List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize);
}
