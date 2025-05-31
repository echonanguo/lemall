package org.echonanguo.lemall.service.impl;

import org.echonanguo.lemall.mapper.CmsPrefrenceAreaMapper;
import org.echonanguo.lemall.model.CmsPrefrenceArea;
import org.echonanguo.lemall.model.CmsPrefrenceAreaExample;
import org.echonanguo.lemall.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选管理Service实现类
 * Created by echonanguo on 2018/6/1.
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
