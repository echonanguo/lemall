package org.echonanguo.lemall.portal.service.impl;

import com.github.pagehelper.PageHelper;
import org.echonanguo.lemall.common.api.CommonPage;
import org.echonanguo.lemall.mbg.mapper.PmsBrandMapper;
import org.echonanguo.lemall.mbg.mapper.PmsProductMapper;
import org.echonanguo.lemall.mbg.model.PmsBrand;
import org.echonanguo.lemall.mbg.model.PmsProduct;
import org.echonanguo.lemall.mbg.model.PmsProductExample;
import org.echonanguo.lemall.portal.dao.HomeDao;
import org.echonanguo.lemall.portal.service.PortalBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 前台品牌管理Service实现类
 * Created by echonanguo on 2025/4/26.
 */
@Service
public class PortalBrandServiceImpl implements PortalBrandService {
    @Autowired
    private HomeDao homeDao;
    @Autowired
    private PmsBrandMapper brandMapper;
    @Autowired
    private PmsProductMapper productMapper;

    @Override
    public List<PmsBrand> recommendList(Integer pageNum, Integer pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return homeDao.getRecommendBrandList(offset, pageSize);
    }

    @Override
    public PmsBrand detail(Long brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

    @Override
    public CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andDeleteStatusEqualTo(0)
                .andBrandIdEqualTo(brandId);
        List<PmsProduct> productList = productMapper.selectByExample(example);
        return CommonPage.restPage(productList);
    }
}
