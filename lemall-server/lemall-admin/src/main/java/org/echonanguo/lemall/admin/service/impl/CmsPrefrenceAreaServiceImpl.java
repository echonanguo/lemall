package org.echonanguo.lemall.admin.service.impl;

import org.echonanguo.lemall.admin.service.CmsPrefrenceAreaService;
import org.echonanguo.lemall.mbg.mapper.CmsPrefrenceAreaMapper;
import org.echonanguo.lemall.mbg.model.CmsPrefrenceArea;
import org.echonanguo.lemall.mbg.model.CmsPrefrenceAreaExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选管理Service实现类
 * Created by echonanguo on 2025/4/22.
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
