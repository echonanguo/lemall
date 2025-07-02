package org.echonanguo.lemall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.echonanguo.lemall.admin.mapper.SmsHomeAdvertiseMapper;
import org.echonanguo.lemall.common.model.SmsHomeAdvertise;
import org.echonanguo.lemall.admin.service.SmsHomeAdvertiseService;
import org.springframework.util.StringUtils;

/**
 * 首页广告管理Service实现类
 * Created by echonanguo on 2025/4/26.
 */
@Service
public class SmsHomeAdvertiseServiceImpl extends ServiceImpl<SmsHomeAdvertiseMapper, SmsHomeAdvertise> implements SmsHomeAdvertiseService{
    @Override
    public int create(SmsHomeAdvertise advertise) {
        advertise.setClickCount(0);
        advertise.setOrderCount(0);
        return baseMapper.insert(advertise);
    }

    @Override
    public int delete(List<Long> ids) {
        return baseMapper.delete(Wrappers.<SmsHomeAdvertise>lambdaQuery()
        .in(SmsHomeAdvertise::getId, ids));
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        SmsHomeAdvertise record = new SmsHomeAdvertise();
        record.setId(id);
        record.setStatus(status);
        return baseMapper.updateById(record);
    }

    @Override
    public SmsHomeAdvertise getItem(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int update(Long id, SmsHomeAdvertise advertise) {
        advertise.setId(id);
        return baseMapper.updateById(advertise);
    }

    @Override
    public List<SmsHomeAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum) {

        // 创建分页对象
        Page<SmsHomeAdvertise> page = new Page<>(pageNum, pageSize);

        // 构建查询条件
        LambdaQueryWrapper<SmsHomeAdvertise> queryWrapper = Wrappers.lambdaQuery();
        if (StringUtils.hasText(name)) {
            queryWrapper.like(SmsHomeAdvertise::getName, name);
        }
        if (type != null) {
            queryWrapper.eq(SmsHomeAdvertise::getType, type);
        }
        if (StringUtils.hasText(endTime)) {
            String startStr = endTime + " 00:00:00";
            String endStr = endTime + " 23:59:59";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date start = sdf.parse(startStr);
                Date end = sdf.parse(endStr);
                queryWrapper.between(SmsHomeAdvertise::getEndTime, start, end);
            } catch (ParseException e) {
                throw new RuntimeException("日期格式转换错误", e);
            }
        }
        queryWrapper.orderByDesc(SmsHomeAdvertise::getSort);

        // 执行分页查询
        return baseMapper.selectPage(page, queryWrapper).getRecords();
    }
}
