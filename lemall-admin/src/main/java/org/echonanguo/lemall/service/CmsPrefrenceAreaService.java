package org.echonanguo.lemall.service;

import org.echonanguo.lemall.model.CmsPrefrenceArea;

import java.util.List;

/**
 * 商品优选管理Service
 * Created by echonanguo on 2018/6/1.
 */
public interface CmsPrefrenceAreaService {
    /**
     * 获取所有优选专区
     */
    List<CmsPrefrenceArea> listAll();
}
