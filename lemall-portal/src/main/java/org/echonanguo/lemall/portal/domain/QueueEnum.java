package org.echonanguo.lemall.portal.domain;

import lombok.Getter;

/**
 * 消息队列枚举配置
 * Created by echonanguo on 2025/1/22.
 */
@Getter
public enum QueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("lemall.order.direct", "lemall.order.cancel", "lemall.order.cancel"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("lemall.order.direct.ttl", "lemall.order.cancel.ttl", "lemall.order.cancel.ttl");

    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
