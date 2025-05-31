package org.echonanguo.lemall.common.annotation;

import java.lang.annotation.*;

/**
 * @Author: echonanguo
 * @CreateTime: 2025-05-31
 * @Description: 自定义注解，有该注解的缓存方法会抛出异常
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
