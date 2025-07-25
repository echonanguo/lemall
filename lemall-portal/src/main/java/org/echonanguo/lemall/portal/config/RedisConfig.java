package org.echonanguo.lemall.portal.config;

import org.echonanguo.lemall.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis相关配置
 * Created by echonanguo on 2025/4/22.
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}
