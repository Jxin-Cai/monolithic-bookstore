package com.github.copy.bookstore.application.service;

import com.github.copy.bookstore.domain.aggregation.account.entity.Account;
import com.github.copy.bookstore.domain.aggregation.account.param.AccountReadParam;
import com.github.copy.bookstore.domain.aggregation.account.param.AccountWriteParam;

/**
 * 用户管理器
 * @author Jxin
 * @since 2021/4/1 8:04 下午
 */
public interface AccountManager {
    /**
     * 根据用户名称获取用户详情
     * @param  accountReadParam 用户查询参数
     * @return 用户实体
     */
    Account getUser(AccountReadParam accountReadParam);
    /**
     * 创建新的用户
     * @param  user 创建用户信息 DTO
     */
    void createUser(AccountWriteParam user);

    /**
     * 更新用户信息
     * @param  user 修改用户信息 DTO
     */
    void modifyUser(AccountWriteParam user);
}
