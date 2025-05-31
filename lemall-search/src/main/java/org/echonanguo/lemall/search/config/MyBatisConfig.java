package org.echonanguo.lemall.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis相关配置
 * Created by echonanguo on 2019/4/8.
 */
@Configuration
@MapperScan({"org.echonanguo.lemall.mapper","org.echonanguo.lemall.search.dao"})
public class MyBatisConfig {
}
