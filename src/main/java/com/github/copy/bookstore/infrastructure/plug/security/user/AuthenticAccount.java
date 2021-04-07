package com.github.copy.bookstore.infrastructure.plug.security.user;

import com.github.copy.bookstore.domain.aggregation.account.entity.Account;
import com.github.copy.bookstore.domain.aggregation.authority.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * 认证用户模型
 * <p>
 * 用户注册之后，包含其业务属性，如姓名、电话、地址，用于业务发生，存储于Account对象中
 * 也包含其用于认证的属性，譬如密码、角色、是否停用，存储于AuthenticAccount对象中
 * @author Jxin
 * @since 2021/4/8 1:20 上午
 */
public class AuthenticAccount implements UserDetails {
    private static final long serialVersionUID = -3152980753682918182L;
    /**用户 实体*/
    private Account account;
    public AuthenticAccount(List<Role> roles, Account account) {
        super();
        roles.stream().map(Role::authorities)
             .flatMap(Collection::stream)
             .map(SimpleGrantedAuthority::new)
             .forEach(authorities::add);
        this.account = account;
    }

    /**
     * 该用户拥有的授权，譬如读取权限、修改权限、增加权限等等
     */
    private Collection<GrantedAuthority> authorities = new HashSet<>();

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    /**
     * 账号是否过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 是否锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否被锁定
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
