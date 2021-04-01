package com.github.copy.bookstore.infrastructure.web.aop;

import com.github.copy.bookstore.resource.global.JaxrsRsp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

/**
 * 统一处理系统异常信息
 * @author Jxin
 * @since 2021/3/31 5:03 下午
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @Context
    private HttpServletRequest request;

    /**
     * 参数校验不通过的异常
     */
    @ExceptionHandler
    @ResponseBody
    public Response handleException(ConstraintViolationException e) {
        log.warn("校验数据不合法, msg: {}, {}: {}", e.getMessage(), request.getMethod(), request.getPathInfo());
        final String msg = e.getConstraintViolations()
                            .stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.joining(";"));
        return JaxrsRsp.send(Response.Status.BAD_REQUEST, msg, null);
    }
    /**
     * 系统异常
     */
    @ExceptionHandler
    @ResponseBody
    public Response handleException(Throwable e){
        log.error(e.getMessage(), e);
        return JaxrsRsp.failure(e.getMessage());
    }

}
