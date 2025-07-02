package org.echonanguo.lemall.admin.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.echonanguo.lemall.admin.mapper.PmsProductMapper;
import org.echonanguo.lemall.common.model.PmsProduct;
import org.echonanguo.lemall.admin.service.PmsProductService;
@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements PmsProductService{

}
