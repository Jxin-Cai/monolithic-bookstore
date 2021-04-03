package com.github.copy.bookstore.domain.aggregation.account.param;

import lombok.Data;

/**
 * 用户 读参数
 * @author 素律
 * @since 2021/4/1 8:06 下午
 */
@Data
public class AccountReadParam {
    /**账号*/
    private String username;

    public static AccountReadParam of(String username){
        final AccountReadParam ret = new AccountReadParam();
        ret.setUsername(username);
        return ret;
    }
}
