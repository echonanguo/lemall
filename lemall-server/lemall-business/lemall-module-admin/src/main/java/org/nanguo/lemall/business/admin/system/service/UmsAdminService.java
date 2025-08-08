package org.nanguo.lemall.business.admin.system.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.nanguo.lemall.business.admin.system.entity.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import org.nanguo.lemall.business.admin.system.entity.UmsRole;

import java.util.List;

public interface UmsAdminService extends IService<UmsAdmin>{

    /**
     * 管理员登录
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    SaTokenInfo login(String username, String password);

    /**
     * 获取当前用户信息
     * @return 用户信息
     */
    UmsAdmin getCurrentAdmin();

    /**
     * 获取用户对于角色
     */
    List<UmsRole> getRoleList(Long id);

    /**
     * 分页查询所有用户
     * @param keyword 关键词
     * @param pageSize 每页条数
     * @param pageNum 页码
     * @return 查询结果
     */
    IPage<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);
}
