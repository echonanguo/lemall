package org.nanguo.lemall.handler;

import lombok.extern.slf4j.Slf4j;
import org.nanguo.lemall.util.response.BizException;
import org.nanguo.lemall.util.response.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handle(MethodArgumentNotValidException e) {
        log.error(e.getMessage(),e);
        return Result.fail("请求参数校验失败");
    }

    @ExceptionHandler(value = BizException.class)
    public Result<?> BizException(BizException e) {
        log.error(e.getMessage(), e);
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result<?> exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return Result.fail("系统异常");
    }
}
