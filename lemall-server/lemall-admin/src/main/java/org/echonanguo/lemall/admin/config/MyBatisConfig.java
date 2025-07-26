package org.echonanguo.lemall.admin.config;

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
@MapperScan({"org.echonanguo.lemall.mbg.mapper","org.echonanguo.lemall.admin.dao"})
public class MyBatisConfig {
}
