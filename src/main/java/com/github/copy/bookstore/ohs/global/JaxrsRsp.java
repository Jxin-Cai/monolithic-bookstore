package com.github.copy.bookstore.ohs.global;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.function.Consumer;

/**
 * Response对象 工具集
 * @author Jxin
 * @since 2021/3/31 4:19 下午
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JaxrsRsp {

    /**
     * 向客户端发送自定义操作信息
     */
    public static <T> Response send(Response.Status status, String msg, T data) {
        final boolean isSuccess = status.getFamily() == Response.Status.Family.SUCCESSFUL;
        if(isSuccess){
            return Response.status(status)
                           .type(MediaType.APPLICATION_JSON)
                           .entity(Result.success(msg, data))
                           .build();
        }
        return Response.status(status)
                       .type(MediaType.APPLICATION_JSON)
                       .entity(Result.failure(msg))
                       .build();
    }

    /**
     * 向客户端发送操作失败的信息
     */
    public static Response failure(String message) {
        return send(Response.Status.INTERNAL_SERVER_ERROR, message, null);
    }

    /**
     * 向客户端发送操作成功的信息
     */
    public static Response success(String message) {
        return send(Response.Status.OK, message, null);
    }

    /**
     * 向客户端发送操作成功的信息
     */
    public static Response success() {
        return send(Response.Status.OK, "操作已成功", null);
    }

    /**
     * 执行操作，并根据操作是否成功返回给客户端相应信息
     * 封装了在服务端接口中很常见的执行操作，用于简化编码
     */
    public static Response op(Runnable executor) {
        return op(executor, e -> {});
    }

    /**
     * 执行操作（带自定义的失败处理），并根据操作是否成功返回给客户端相应信息
     * 封装了在服务端接口中很常见的执行操作，用于简化编码
     */
    public static Response op(Runnable executor, Consumer<Exception> exceptionConsumer) {
        try {
            executor.run();
            return JaxrsRsp.success();
        } catch (Exception e) {
            exceptionConsumer.accept(e);
            throw e;
        }
    }
}
