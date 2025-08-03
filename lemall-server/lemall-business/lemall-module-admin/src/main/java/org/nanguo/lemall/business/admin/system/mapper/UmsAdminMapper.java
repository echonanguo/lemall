package org.nanguo.lemall.business.admin.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.nanguo.lemall.business.admin.system.entity.UmsAdmin;
import org.nanguo.lemall.business.admin.system.entity.UmsResource;

import java.util.List;

public interface UmsAdminMapper extends BaseMapper<UmsAdmin> {

    List<UmsResource> getResourceList(@Param("adminId") Long adminId);


}