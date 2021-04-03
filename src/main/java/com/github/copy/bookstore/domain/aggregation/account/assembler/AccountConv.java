package com.github.copy.bookstore.domain.aggregation.account.assembler;

import com.github.copy.bookstore.domain.aggregation.account.entity.Account;
import com.github.copy.bookstore.domain.aggregation.account.param.AccountWriteParam;
import org.mapstruct.Mapper;

/**
 * 用户 聚合转换器
 * @author 素律
 * @since 2021/4/1 7:40 下午
 */
@Mapper(componentModel = "spring")
public interface AccountConv {
    /**
     * param转用户 实体
     * @param  accountWriteParam 用户 参数
     * @return 用户 实体
     */
    Account param2Account(AccountWriteParam accountWriteParam);

}
