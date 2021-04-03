package com.github.copy.bookstore.ohs.resource.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息 DTO
 * @author Jxin
 * @since 2021/3/30 2:25 下午
 */
@Data
@ApiModel("创建用户信息 DTO")
public class AccountDto implements Serializable {
    private static final long serialVersionUID = 6901810952087040747L;
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "账户")
    private String username;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "电话")
    private String telephone;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "地址")
    private String location;
}
