package com.github.copy.bookstore.domain.service.validator.account;

import com.github.copy.bookstore.domain.aggregation.account.entity.Account;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.function.Predicate;

/**
 * 用户校验实现类
 * @author 素律
 * @since 2021/4/2 10:56 上午
 */
public class AccountValidation <T extends Annotation> implements ConstraintValidator<T, Account> {
    protected Predicate<Account> predicate = a -> true;

    @Override
    public boolean isValid(Account account, ConstraintValidatorContext constraintValidatorContext) {
        return predicate.test(account);
    }
}
