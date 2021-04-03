package com.github.copy.bookstore.domain.acl.repository;

import com.github.copy.bookstore.domain.aggregation.account.entity.Account;
import com.github.copy.bookstore.domain.aggregation.account.param.AccountReadParam;
import com.github.copy.bookstore.domain.service.validator.account.UniqueAccount;
import com.github.copy.bookstore.infrastructure.acl.repository.err.DbWriteException;

/**
 * 用户聚合仓库
 * @author 素律
 * @since 2021/4/1 8:45 下午
 */
public interface AccountRepository {
    /**
     * 获取用户实体
     * @param  accountReadParam 用户 读参数
     * @return 用户 实体
     */
    Account get(AccountReadParam accountReadParam);

    /**
     * 保存用户信息
     * @param account 用户 实体
     * @throws DbWriteException 保存用户信息失败
     */
    void saveUser(@UniqueAccount Account account);
    /**
     * 更新用户信息(非null值才更新)
     * @param account 用户 实体
     * @throws DbWriteException 更新用户信息失败
     */
    void updateUser(@UniqueAccount Account account);

    /**
     * 唯一校验
     * @param  account 用户 实体
     * @return 唯一返回 true
     */
    boolean uniqueCheck(Account account);
}
