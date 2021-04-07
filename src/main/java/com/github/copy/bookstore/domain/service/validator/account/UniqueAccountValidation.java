package com.github.copy.bookstore.domain.service.validator.account;


import com.github.copy.bookstore.domain.aggregation.account.acl.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户校验器 唯一校验
 * @author Jxin
 * @since 2021/4/2 11:45 上午
 */
public class UniqueAccountValidation extends AccountValidation<UniqueAccount>{
    @Autowired
    private AccountRepository repository;

    @Override
    public void initialize(UniqueAccount constraintAnnotation) {
        predicate = account ->  repository.uniqueCheck(account);
    }
}
