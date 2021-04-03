package com.github.copy.bookstore.ohs.resource.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 修改用户信息 DTO
 * @author Jxin
 * @since 2021/3/30 2:25 下午
 */
@Data
@ApiModel("修改用户信息 DTO")
public class ModifyAccountDto implements Serializable {
    private static final long serialVersionUID = 6901810952087040747L;
    @ApiModelProperty(value = "用户id")
    private Integer id;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "名称")
    @NotEmpty(message = "用户姓名不允许为空")
    private String name;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "电话")
    @Pattern(regexp = "1\\d{10}", message = "手机号格式不正确")
    private String telephone;
    @ApiModelProperty(value = "邮箱")
    @Email(message = "邮箱格式不正确")
    private String email;
    @ApiModelProperty(value = "地址")
    private String location;
}
