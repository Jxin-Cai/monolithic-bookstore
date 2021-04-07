package com.github.copy.bookstore.infrastructure.plug.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * 访问令牌服务 配置类
 * @author Jxin
 * @since 2021/4/8 12:53 上午
 */
@Configuration
public class AccessTokenServiceConfiguration {
    @Bean
    @Autowired
    public DefaultTokenServices getTokenServices(AccessTokenConverter token,
                                                 ClientDetailsService clientService,
                                                 AuthenticationManager authenticationManager) {
        final DefaultTokenServices ret = new DefaultTokenServices();
        // 设置令牌的持久化容器
        // 令牌持久化有多种方式，单节点服务可以存放在Session中，集群可以存放在Redis中
        // 而JWT是后端无状态、前端存储的解决方案，Token的存储由前端完成
        ret.setTokenStore(new JwtTokenStore(token));
        // 令牌支持的客户端详情
        ret.setClientDetailsService(clientService);
        // 设置验证管理器，在鉴权的时候需要用到
        ret.setAuthenticationManager(authenticationManager);
        // 定义令牌的额外负载
        ret.setTokenEnhancer(token);
        // access_token有效期，单位：秒，默认12小时
        ret.setAccessTokenValiditySeconds(60 * 60 * 3);
        // refresh_token的有效期，单位：秒, 默认30天
        // 这决定了客户端选择“记住当前登录用户”的最长时效，即失效前都不用再请求用户赋权了
        ret.setRefreshTokenValiditySeconds(60 * 60 * 24 * 15);
        // 是否支持refresh_token，默认false
        ret.setSupportRefreshToken(true);
        // 是否复用refresh_token，默认为true
        // 如果为false，则每次请求刷新都会删除旧的refresh_token，创建新的refresh_token
        ret.setReuseRefreshToken(true);
        return ret;
    }
}
