package org.echonanguo.lemall.admin.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.echonanguo.lemall.common.model.UmsMemberLevel;
import org.echonanguo.lemall.admin.mapper.UmsMemberLevelMapper;
import org.echonanguo.lemall.admin.service.UmsMemberLevelService;
@Service
public class UmsMemberLevelServiceImpl extends ServiceImpl<UmsMemberLevelMapper, UmsMemberLevel> implements UmsMemberLevelService{
    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {

        return baseMapper.selectList(Wrappers.<UmsMemberLevel>lambdaQuery()
                .eq(UmsMemberLevel::getDefaultStatus, defaultStatus)
        );
    }
}
