package com.github.copy.bookstore.resource.global;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * 对外接口统一返回实体
 * @author Jxin
 * @since 2021/3/31 4:24 下午
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@ApiModel("统一返回实体")
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -9147195937035970909L;
    /**成功标志*/
    public static final Integer SUCCESS = 0;
    /**失败标志*/
    public static final Integer FAILURE = 1;
    @ApiModelProperty(value = "异常code")
    private final Integer code;
    @ApiModelProperty(value = "消息")
    private final String msg;
    @ApiModelProperty(value = "数据")
    private final T data;


    public static Result<Void> success(){
        return new Result<>(SUCCESS, null, null);
    }
    public static Result<Void> success(String msg){
        return new Result<>(SUCCESS, msg, null);
    }
    public static <T> Result<T> success(String msg, T data){
        return new Result<>(SUCCESS, msg, data);
    }
    public static Result<Void> failure(String msg){
        return new Result<>(FAILURE, msg, null);
    }
    public static <T> Result<T> failure(String msg, Class<T> clazz){
        return new Result<>(FAILURE, msg, null);
    }

    public boolean isSuccess(){
        return SUCCESS.equals(code);
    }
    public boolean isFailure(){
        return FAILURE.equals(code);
    }
}
