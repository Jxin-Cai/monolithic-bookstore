package com.github.copy.bookstore.infrastructure.plug.security.user;

import com.github.copy.bookstore.domain.aggregation.account.acl.repository.AccountRepository;
import com.github.copy.bookstore.domain.aggregation.account.entity.Account;
import com.github.copy.bookstore.domain.aggregation.account.param.AccountReadParam;
import com.github.copy.bookstore.domain.aggregation.authority.acl.repository.RoleRepository;
import com.github.copy.bookstore.domain.aggregation.authority.entity.Role;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 *
 * 认证用户的数据仓库 简单实现
 * @author Jxin
 * @since 2021/4/8 1:31 上午
 */
@Repository
@AllArgsConstructor
public class SimpleAuthenticAccountRepository implements AuthenticAccountRepository{
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    @Override
    public AuthenticAccount findByUsername(String username) {
        final Account account = accountRepository.get(AccountReadParam.of(username));
        // 本应用 用户与角色 的关联id 来获取角色列表。没有则写死将就。
        final Role role = roleRepository.get(account.getId());
        return new AuthenticAccount(Lists.newArrayList(role), account);
    }
}
