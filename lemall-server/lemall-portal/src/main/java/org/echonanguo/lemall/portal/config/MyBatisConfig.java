package org.echonanguo.lemall.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 * Created by echonanguo on 2025/4/27.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"org.echonanguo.lemall.mbg.mapper","org.echonanguo.lemall.portal.dao"})
public class MyBatisConfig {
}
