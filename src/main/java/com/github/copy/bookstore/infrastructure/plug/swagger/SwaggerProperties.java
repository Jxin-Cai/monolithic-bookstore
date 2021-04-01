package com.github.copy.bookstore.infrastructure.plug.swagger;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * swagger的配置参数
 * @author Jxin
 * @since 2021/3/31 5:42 下午
 */
@Data
@Validated
public class SwaggerProperties {
    /**扫包路径*/
    @NotNull(message = "basePackage未配置,SwaggerUi不生成")
    private String basePackage;
    /**标题*/
    @NotNull(message = "title未配置,SwaggerUi不生成")
    private String title;
    /**详情*/
    private String description;
    /**版本*/
    @NotNull(message = "version未配置,SwaggerUi不生成")
    private String version;
    /**负责人姓名*/
    @NotNull(message = "name未配置,SwaggerUi不生成")
    private String name;
    /**邮箱*/
    @Email(message = "邮箱不合规,SwaggerUi不生成")
    private String email;
}
