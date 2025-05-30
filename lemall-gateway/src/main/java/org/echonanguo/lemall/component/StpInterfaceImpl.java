package org.echonanguo.lemall.component;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import org.echonanguo.lemall.common.constant.AuthConstant;
import org.echonanguo.lemall.common.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: echonanguo
 * @CreateTime: 2025-05-31
 * @Description: 自定义权限验证接口扩展
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 返回此loginId拥有的权限码列表
        if(StpUtil.getLoginType().equals(loginType)){
            //后台用户需返回
            UserDto userdto = (UserDto) StpUtil.getSession().get(AuthConstant.STP_ADMIN_INFO);
            return userdto.getPermissionList();
        }else{
            //前台用户无需返回
            return null;
        }
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的角色码列表
        return null;
    }

}
