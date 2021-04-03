package com.github.copy.bookstore.infrastructure.acl.repository.assembler;

import com.github.copy.bookstore.domain.aggregation.account.entity.Account;
import com.github.copy.bookstore.infrastructure.acl.repository.table.AccountDo;
import org.mapstruct.Mapper;

/**
 * 用户 do转换器
 * @author 素律
 * @since 2021/4/1 7:40 下午
 */
@Mapper(componentModel = "spring")
public interface AccountDoConv {
    /**
     * do转用户 实体
     * @param  accountDo 用户 do
     * @return 用户 实体
     */
    Account do2Account(AccountDo accountDo);
    /**
     * 用户实体 转do
     * @param  account 用户 实体
     * @return 用户 实体
     */
    AccountDo account2Do(Account account);

}
