package com.github.copy.bookstore.domain.aggregation.account.factory;

import com.github.copy.bookstore.domain.aggregation.account.assembler.AccountConv;
import com.github.copy.bookstore.domain.aggregation.account.entity.Account;
import com.github.copy.bookstore.domain.aggregation.account.param.AccountWriteParam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 用户工厂类
 * @author Jxin
 * @since 2021/4/1 7:57 下午
 */
@Component
@AllArgsConstructor
public class AccountFactory {
    private final AccountConv accountConv;
    public Account of(AccountWriteParam accountWriteParam){
        return accountConv.param2Account(accountWriteParam);
    }
}
