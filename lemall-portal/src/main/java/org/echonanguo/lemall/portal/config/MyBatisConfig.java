package org.echonanguo.lemall.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 * Created by echonanguo on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"org.echonanguo.lemall.mapper","org.echonanguo.lemall.portal.dao"})
public class MyBatisConfig {
}
