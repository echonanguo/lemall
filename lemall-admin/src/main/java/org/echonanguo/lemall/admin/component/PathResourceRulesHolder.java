package org.echonanguo.lemall.admin.component;

import org.echonanguo.lemall.admin.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

/*
 * @Description: 路径与资源访问对应关系操作组件
 * @Author:  echonanguo
 * @date:  2025/5/31 下午11:07
 */
@Component
public class PathResourceRulesHolder {

    @Autowired
    private UmsResourceService resourceService;

    @PostConstruct
    public void initPathResourceMap(){
        resourceService.initPathResourceMap();
    }
}
