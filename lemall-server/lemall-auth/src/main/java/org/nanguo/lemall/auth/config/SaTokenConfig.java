package org.nanguo.lemall.auth.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaRequest;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.nanguo.lemall.auth.constant.AuthConstant;
import org.nanguo.lemall.auth.util.StpMemberUtil;
import org.nanguo.lemall.util.response.Result;
import org.nanguo.lemall.util.response.ResultCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.server.PathContainer;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * sa-token配置类
 */
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(IgnoreUrlsConfig.class)
public class SaTokenConfig {

    private final RedisTemplate<String, Object> redisTemplate;
    @Value("${lemall.server.prefix.portal}")
    private String portalPrefix;
    @Value("${lemall.server.prefix.admin}")
    private String adminPrefix;

    private final IgnoreUrlsConfig ignoreUrlsConfig;
    private final PathPatternParser patternParser = PathPatternParser.defaultInstance; // 路径解析器
    private final ConcurrentMap<String, PathPattern> patternCache = new ConcurrentHashMap<>(); // 缓存解析后的 PathPattern，提高匹配效率。

    @Bean
    public SaServletFilter getSaServletFilter() {
        return new SaServletFilter()
                .addInclude("/**")
                .setExcludeList(ignoreUrlsConfig.getUrls())
                .setAuth(obj -> {
                    SaRequest request = SaHolder.getRequest();
                    String requestPath = request.getRequestPath();

                    // 2. 检查是否登录，未登录直接抛出异常
                    SaRouter.match(portalPrefix + "/**", r -> StpMemberUtil.checkLogin()).stop();
                    SaRouter.match(adminPrefix + "/**", r -> StpUtil.checkLogin());
                    // 3. 从 Redis 中读取「路径 - 权限」的映射表，key 是路径模式，value 是权限标识
                    Map<Object, Object> pathResourceMap = redisTemplate.opsForHash()
                            .entries(AuthConstant.PATH_RESOURCE_MAP);
                    // 4. 初始化要校验的权限列表，解析当前请求路径为 PathContainer 方便后续匹配
                    List<String> needPermissionList = new ArrayList<>();
                    PathContainer pathToMatch = PathContainer.parsePath(requestPath);

                    // 5. 遍历所有路径模式，和当前请求路径进行匹配，如果匹配上了，把对应的权限添加到needPermissionList中
                    for (Map.Entry<Object, Object> entry : pathResourceMap.entrySet()) {
                        String patternStr = (String) entry.getKey();
                        PathPattern pattern = patternCache.computeIfAbsent(patternStr, patternParser::parse);
                        if (pattern.matches(pathToMatch)) {
                            needPermissionList.add((String) entry.getValue());
                        }
                    }

                    if (!needPermissionList.isEmpty()) {
                        StpUtil.checkPermissionOr(Convert.toStrArray(needPermissionList));
                    }
                })
                .setBeforeAuth(obj -> {
                    SaHolder.getResponse()
                            // ---------- 设置跨域响应头 ----------
                            // 允许指定域访问跨域资源
                            .setHeader("Access-Control-Allow-Origin", "*")
                            // 允许所有请求方式
                            .setHeader("Access-Control-Allow-Methods", "*")
                            // 允许的header参数
                            .setHeader("Access-Control-Allow-Headers", "*")
                            // 有效时间
                            .setHeader("Access-Control-Max-Age", "3600");

                    // 如果是预检请求，则立即返回到前端
                    SaRouter.match(SaHttpMethod.OPTIONS)
                            .free(r -> System.out.println("--------OPTIONS预检请求，不做处理"))
                            .back();
                })
                // 异常处理
                .setError(e -> {
                    HttpServletResponse response = (HttpServletResponse) SaHolder.getResponse();
                    response.setHeader("Content-Type", "application/json; charset=utf-8");
                    response.setHeader("Access-Control-Allow-Origin", "*");
                    response.setHeader("Cache-Control", "no-cache");
                    Result<?> result;
                    if (e instanceof NotLoginException) {
                        result = Result.fail(ResultCode.UNAUTHORIZED);
                    } else if (e instanceof NotPermissionException) {
                        result = Result.fail(ResultCode.FORBIDDEN);
                    } else {
                        result = Result.fail(e.getMessage());
                    }
                    return JSONUtil.toJsonStr(result);
                });
    }

    // Sa-Token 整合 jwt (Simple 简单模式)
    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForSimple();
    }
}


