package com.github.copy.bookstore.resource.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 用户信息 DTO
 * @author Jxin
 * @since 2021/3/30 2:25 下午
 */
@Data
@ApiModel("用户信息 DTO")
public class AccountDto implements Serializable {
    private static final long serialVersionUID = 6901810952087040747L;
    /**账户*/

    @ApiModelProperty(value = "账户", required=true)
    @NotEmpty(message = "用户不允许为空")
    private String username;
    /**
     * 用户密码
     * (不允许json序列化)
     */
    @ApiModelProperty(value = "用户密码")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ApiModelProperty(value = "名称", required=true)
    @NotEmpty(message = "用户姓名不允许为空")
    private String name;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "电话", required=true)
    @Pattern(regexp = "1\\d{10}", message = "手机号格式不正确")
    private String telephone;

    @ApiModelProperty(value = "邮箱", required=true)
    @Email(message = "邮箱格式不正确")
    private String email;

    @ApiModelProperty(value = "地址")
    private String location;
}
