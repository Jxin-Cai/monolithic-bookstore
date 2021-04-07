package com.github.copy.bookstore.infrastructure.plug.security.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 认证用户信息查询服务
 * <p>
 * {@link UserDetailsService}接口定义了从外部（数据库、LDAP，任何地方）根据用户名查询到
 * @author Jxin
 * @since 2021/4/8 1:47 上午
 */
@Component
@AllArgsConstructor
public class AuthenticAccountDetailsService implements UserDetailsService {
    private final AuthenticAccountRepository authenticAccountRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return authenticAccountRepository.findByUsername(s);
    }
}
