package com.github.copy.bookstore.application.service.impl;

import com.github.copy.bookstore.application.service.AccountManager;
import com.github.copy.bookstore.domain.acl.repository.AccountRepository;
import com.github.copy.bookstore.domain.aggregation.account.entity.Account;
import com.github.copy.bookstore.domain.aggregation.account.factory.AccountFactory;
import com.github.copy.bookstore.domain.aggregation.account.param.AccountReadParam;
import com.github.copy.bookstore.domain.aggregation.account.param.AccountWriteParam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 默认的管理器实现
 * @author 素律
 * @since 2021/4/1 8:22 下午
 */
@Component
@AllArgsConstructor
public class DefAccountManager implements AccountManager {
    private final AccountRepository accountRepository;
    private final AccountFactory accountFactory;
    @Override
    public Account getUser(AccountReadParam accountReadParam) {
        return accountRepository.get(accountReadParam);
    }

    @Override
    public void createUser(AccountWriteParam user) {
        final Account account = accountFactory.of(user);
        accountRepository.saveUser(account);
    }

    @Override
    public void modifyUser(AccountWriteParam user) {
        final Account account = accountFactory.of(user);
        accountRepository.updateUser(account);
    }
}
