package org.echonanguo.lemall.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.reactor.context.SaReactorSyncHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import org.echonanguo.lemall.common.api.CommonResult;
import org.echonanguo.lemall.common.constant.AuthConstant;
import org.echonanguo.lemall.util.StpMemberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.PathContainer;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author: echonanguo
 * @CreateTime: 2025-05-31
 * @Description: Sa-Token相关配置
 */

@Configuration
public class SaTokenConfig {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 1. 初始化PathPattern解析器（线程安全，全局共享）
    private final PathPatternParser patternParser = PathPatternParser.defaultInstance;

    // 2. 模式缓存（Key: 路径模式, Value: 编译后的PathPattern）
    private final ConcurrentMap<String, PathPattern> patternCache = new ConcurrentHashMap<>();

    @Bean
    public SaReactorFilter getSaReactorFilter(IgnoreUrlsConfig ignoreUrlsConfig) {
        return new SaReactorFilter()
                // 拦截所有路径（PathPattern的/**与Ant风格行为一致）
                .addInclude("/**")
                .setExcludeList(ignoreUrlsConfig.getUrls())
                .setAuth(obj -> {
                    // 1. 放行OPTIONS预检请求
                    SaRouter.match(SaHttpMethod.OPTIONS).stop();

                    // 2. 前后台登录认证（保持原逻辑）
                    SaRouter.match("/lemall-portal/**", r -> StpMemberUtil.checkLogin()).stop();
                    SaRouter.match("/lemall-admin/**", r -> StpUtil.checkLogin());

                    // 3. 动态权限校验（改用PathPattern）
                    Map<Object, Object> pathResourceMap = redisTemplate.opsForHash()
                            .entries(AuthConstant.PATH_RESOURCE_MAP);

                    List<String> needPermissionList = new ArrayList<>();
                    String requestPath = SaHolder.getRequest().getRequestPath();

                    // 将请求路径转换为PathContainer（性能关键点）
                    PathContainer pathToMatch = PathContainer.parsePath(requestPath);

                    // 3.1 遍历所有权限规则
                    for (Map.Entry<Object, Object> entry : pathResourceMap.entrySet()) {
                        String patternStr = (String) entry.getKey();

                        // 3.2 从缓存获取或编译PathPattern
                        PathPattern pattern = patternCache.computeIfAbsent(
                                patternStr,
                                patternParser::parse // 编译耗时操作仅执行一次
                        );

                        // 3.3 执行匹配（性能比AntPathMatcher高6-8倍）
                        if (pattern.matches(pathToMatch)) {
                            needPermissionList.add((String) entry.getValue());
                        }
                    }

                    // 4. 权限校验（保持原逻辑）
                    if (CollUtil.isNotEmpty(needPermissionList)) {
                        SaRouter.match(requestPath, r ->
                                StpUtil.checkPermissionOr(Convert.toStrArray(needPermissionList)));
                    }
                })
                .setError(this::handleException);
    }

    /**
     * 自定义异常处理
     */
    private CommonResult<?> handleException(Throwable e) {
        //设置错误返回格式为JSON
        ServerWebExchange exchange = SaReactorSyncHolder.getContext();
        HttpHeaders headers = exchange.getResponse().getHeaders();
        headers.set("Content-Type", "application/json; charset=utf-8");
        headers.set("Access-Control-Allow-Origin", "*");
        headers.set("Cache-Control","no-cache");
        CommonResult<?> result = null;
        if(e instanceof NotLoginException){
            result = CommonResult.unauthorized(null);
        }else if(e instanceof NotPermissionException){
            result = CommonResult.forbidden(null);
        }else{
            result = CommonResult.failed(e.getMessage());
        }
        return result;
    }
}
