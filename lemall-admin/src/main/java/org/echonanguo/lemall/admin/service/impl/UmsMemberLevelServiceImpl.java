package org.echonanguo.lemall.admin.service.impl;

import org.echonanguo.lemall.mbg.mapper.UmsMemberLevelMapper;
import org.echonanguo.lemall.mbg.model.UmsMemberLevel;
import org.echonanguo.lemall.mbg.model.UmsMemberLevelExample;
import org.echonanguo.lemall.admin.service.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员等级管理Service实现类
 * Created by echonanguo on 2025/4/26.
 */
@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService{
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;
    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        UmsMemberLevelExample example = new UmsMemberLevelExample();
        example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        return memberLevelMapper.selectByExample(example);
    }
}
