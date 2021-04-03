package com.github.copy.bookstore.infrastructure.acl.repository.mybatis;

import com.github.copy.bookstore.domain.acl.repository.AccountRepository;
import com.github.copy.bookstore.domain.aggregation.account.entity.Account;
import com.github.copy.bookstore.domain.aggregation.account.param.AccountReadParam;
import com.github.copy.bookstore.domain.service.validator.account.UniqueAccount;
import com.github.copy.bookstore.infrastructure.acl.repository.DbUtil;
import com.github.copy.bookstore.infrastructure.acl.repository.assembler.AccountDoConv;
import com.github.copy.bookstore.infrastructure.acl.repository.mybatis.dao.AccountDoMapper;
import com.github.copy.bookstore.infrastructure.acl.repository.table.AccountDo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

/**
 * 用户聚合仓库 mybatis实现
 * @author 素律
 * @since 2021/4/1 8:48 下午
 */
@Repository
@Validated
@AllArgsConstructor
public class MybatisAccountRepository implements AccountRepository {
    private final AccountDoConv accountDoConv;
    private final AccountDoMapper accountDoMapper;
    @Override
    public Account get(AccountReadParam accountReadParam) {
        final AccountDo accountDo = accountDoMapper.getByUsername(accountReadParam.getUsername());
        return Optional.ofNullable(accountDo)
                       .map(accountDoConv::do2Account)
                       .orElse(null);
    }

    @Override
    public void saveUser(@UniqueAccount Account account) {
        final AccountDo accountDo = accountDoConv.account2Do(account);
        DbUtil.opIsOne(()-> accountDoMapper.insert(accountDo));
    }

    @Override
    public void updateUser(@UniqueAccount Account account) {
        final AccountDo accountDo = accountDoConv.account2Do(account);
        DbUtil.opIsOne(()-> accountDoMapper.updateByPrimaryKeySelective(accountDo));
    }

    @Override
    public boolean uniqueCheck(Account account) {
        return DbUtil.test(()->
                accountDoMapper.findByUsernameOrTelephoneOrEmail(account.getUsername(),
                                                                 account.getTelephone(),
                                                                 account.getEmail()),
                accounts -> notRepetition(account, accounts));
    }

    /**
     *
     * 不存在重复
     * @param  account  用户实体
     * @param  accounts 用户do列表
     * @return 不存在重复则返回 true
     */
    private boolean notRepetition(Account account, List<AccountDo> accounts) {
        final long count = accounts.stream()
                                   .filter(accountDo -> !accountDo.getId().equals(account.getId()))
                                   .count();
          return count < 1;
    }
}
