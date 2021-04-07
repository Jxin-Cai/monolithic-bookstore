package com.github.copy.bookstore.infrastructure.plug.security.user;

/**
 *
 * 认证用户的数据仓库
 * @author Jxin
 * @since 2021/4/8 1:31 上午
 */
public interface AuthenticAccountRepository {
    /**
     * 根据用户名 获取认证用户
     * @param  username 用户名
     * @return 认证用户
     */
    AuthenticAccount findByUsername(String username);
}
