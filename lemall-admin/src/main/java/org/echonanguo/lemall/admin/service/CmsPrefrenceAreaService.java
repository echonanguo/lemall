package org.echonanguo.lemall.admin.service;

import org.echonanguo.lemall.mbg.model.CmsPrefrenceArea;

import java.util.List;

/**
 * 商品优选管理Service
 * Created by echonanguo on 2025/4/22.
 */
public interface CmsPrefrenceAreaService {
    /**
     * 获取所有优选专区
     */
    List<CmsPrefrenceArea> listAll();
}
