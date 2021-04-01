//package com.github.copy.bookstore.infrastructure.web.aop;
//
//import com.github.copy.bookstore.resource.global.JaxrsRsp;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.access.AccessDeniedException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.ext.ExceptionMapper;
//import javax.ws.rs.ext.Provider;
//
///**
// * 统一处理在Resource中由于Spring Security授权访问产生的异常信息
// * @author Jxin
// * @since 2021/3/31 5:03 下午
// */
//@Slf4j
//@Provider
//public class AccessDeniedExceptionAop implements ExceptionMapper<AccessDeniedException> {
//    @Context
//    private HttpServletRequest request;
//    @Override
//    public Response toResponse(AccessDeniedException e) {
//        log.warn("越权访问被禁止, {}: {}", request.getMethod(), request.getPathInfo());
//        return JaxrsRsp.send(Response.Status.FORBIDDEN, e.getMessage(), null);
//    }
//}
