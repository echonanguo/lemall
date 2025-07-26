package org.echonanguo.lemall.admin.service.impl;

import com.github.pagehelper.PageHelper;
import org.echonanguo.lemall.mbg.mapper.CmsSubjectMapper;
import org.echonanguo.lemall.mbg.model.CmsSubject;
import org.echonanguo.lemall.mbg.model.CmsSubjectExample;
import org.echonanguo.lemall.admin.service.CmsSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 商品专题管理Service实现类
 * Created by echonanguo on 2025/4/22.
 */
@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {
    @Autowired
    private CmsSubjectMapper subjectMapper;

    @Override
    public List<CmsSubject> listAll() {
        return subjectMapper.selectByExample(new CmsSubjectExample());
    }

    @Override
    public List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        CmsSubjectExample example = new CmsSubjectExample();
        CmsSubjectExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andTitleLike("%" + keyword + "%");
        }
        return subjectMapper.selectByExample(example);
    }
}
