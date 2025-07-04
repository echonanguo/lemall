package org.echonanguo.lemall.portal.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import org.echonanguo.lemall.mbg.model.UmsMember;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员管理Service
 * Created by echonanguo on 2025/1/22.
 */
public interface UmsMemberService {
    /**
     * 根据用户名获取会员
     */
    UmsMember getByUsername(String username);

    /**
     * 根据会员编号获取会员
     */
    UmsMember getById(Long id);

    /**
     * 用户注册
     */
    @Transactional
    void register(String username, String password, String telephone, String authCode);

    /**
     * 生成验证码
     */
    String generateAuthCode(String telephone);

    /**
     * 修改密码
     */
    @Transactional
    void updatePassword(String telephone, String password, String authCode);

    /**
     * 获取当前登录会员
     */
    UmsMember getCurrentMember();

    /**
     * 根据会员id修改会员积分
     */
    void updateIntegration(Long id,Integer integration);

    /**
     * 登录后获取token
     */
    SaTokenInfo login(String username, String password);

    /**
     * 登出功能
     */
    void logout();
}
