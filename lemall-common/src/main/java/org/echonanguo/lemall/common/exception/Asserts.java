package org.echonanguo.lemall.common.exception;


import org.echonanguo.lemall.common.api.IErrorCode;
/**
 * @Author: echonanguo
 * @CreateTime: 2025-05-31
 * @Description: 断言处理类，用于抛出各种API异常
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
