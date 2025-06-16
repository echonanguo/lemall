package org.echonanguo.lemall.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/*
 * @Description: MyBatis相关配置
 * @Author:  echonanguo
 * @date:  2025/6/1 上午12:33
 */
@Configuration
@MapperScan({"org.echonanguo.lemall.mbg.mapper","org.echonanguo.lemall.search.dao"})
public class MyBatisConfig {
}
