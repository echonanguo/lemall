package org.echonanguo.lemall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 * @Description: MyBatis相关配置
 * @Author:  echonanguo
 * @date:  2025/5/31 下午11:08
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"org.echonanguo.lemall.mapper","org.echonanguo.lemall.dao"})
public class MyBatisConfig {
}
