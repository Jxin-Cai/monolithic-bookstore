package com.github.copy.bookstore.infrastructure.plug.swagger;

import com.github.copy.bookstore.infrastructure.spring.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Nullable;

/**
 * Swagger的配置类
 * @author Jxin
 * @since 2021/3/31 5:39 下午
 */
@Configuration
@ConditionalOnClass(Docket.class)
@Validated
@Slf4j
public class SwaggerConfiguration implements EnvironmentAware {
    /**环境变量对象*/
    private ConfigurableEnvironment environment;
    @Bean
    public Docket createRestApi() {
        final SwaggerProperties swaggerProperties = getSwaggerProperties();
        if(swaggerProperties == null){
            return null;
        }
        return new Docket(DocumentationType.OAS_30)
                    .apiInfo(getApiInfo(swaggerProperties))
                    .select()
                    .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                    .paths(PathSelectors.any())
                    .build();
    }

    /**
     * 从环境变量获取Swagger配置参数
     * @return Swagger配置参数
     * @author Jxin
     */
    private SwaggerProperties getSwaggerProperties() {
        final SwaggerProperties result;
        try {
            result = SpringUtil.resolveSetting(SwaggerProperties.class, "swagger", getEnvironment());
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return null;
        }
        return result;
    }

    /**
     * 获取api初始化对象
     * @param  swaggerProperties swagger的配置参数对象
     * @return {@link ApiInfo} Api初始化对象
     * @author Jxin
     */
    private ApiInfo getApiInfo(SwaggerProperties swaggerProperties) {
        return new ApiInfoBuilder()
                    // 版本
                    .version(swaggerProperties.getVersion())
                    //标题
                    .title(swaggerProperties.getTitle())
                    //描述
                    .description(swaggerProperties.getDescription())
                    //作者
                    .contact(new Contact(swaggerProperties.getName(), "", swaggerProperties.getEmail()))
                    .build();
    }

    @Override
    public void setEnvironment(@Nullable Environment environment) {
        this.environment = (ConfigurableEnvironment) environment;
    }

    private ConfigurableEnvironment getEnvironment() {
        return environment;
    }
}
