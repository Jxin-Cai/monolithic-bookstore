package com.github.copy.bookstore.infrastructure.web.aop;

import com.github.copy.bookstore.ohs.global.JaxrsRsp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
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

    /**
     * 参数校验不通过的异常
     */
    @ExceptionHandler
    @ResponseBody
    public Response handleException(MethodArgumentNotValidException e, HttpServletRequest request) {
        final String msg = e.getAllErrors()
                            .stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining(";"));
        log.warn("校验数据不合法, msg: {}；请求路径: {}: {}。", msg, request.getRequestURI(), request.getMethod());
        return JaxrsRsp.send(Response.Status.BAD_REQUEST, msg, null);
    }
    /**
     * 参数校验不通过的异常
     */
    @ExceptionHandler
    @ResponseBody
    public Response handleException(ConstraintViolationException e, HttpServletRequest request) {
        final String msg = e.getConstraintViolations()
                            .stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.joining(";"));
        log.warn("校验数据不合法, msg: {}；请求路径: {}: {}。", msg, request.getRequestURI(), request.getMethod());
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
