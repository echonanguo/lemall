package org.echonanguo.lemall.portal.service;


import org.echonanguo.lemall.portal.domain.AliPayParam;

import java.util.Map;

/**
 * @auther echonanguo
 * @description 支付宝支付Service
 * @date 2025/9/8
 * @github https://github.com/echonanguo
 */
public interface AlipayService {
    /**
     * 根据提交参数生成电脑支付页面
     */
    String pay(AliPayParam aliPayParam);

    /**
     * 支付宝异步回调处理
     */
    String notify(Map<String, String> params);

    /**
     * 查询支付宝交易状态
     * @param outTradeNo 商户订单编号
     * @param tradeNo 支付宝交易编号
     * @return 支付宝交易状态
     */
    String query(String outTradeNo, String tradeNo);

    /**
     * 根据提交参数生成手机支付页面
     */
    String webPay(AliPayParam aliPayParam);
}
