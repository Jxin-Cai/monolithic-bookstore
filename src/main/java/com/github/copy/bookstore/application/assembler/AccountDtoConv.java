package com.github.copy.bookstore.application.assembler;

import com.github.copy.bookstore.domain.aggregation.account.entity.Account;
import com.github.copy.bookstore.domain.aggregation.account.param.AccountWriteParam;
import com.github.copy.bookstore.ohs.resource.dto.AccountDto;
import com.github.copy.bookstore.ohs.resource.dto.CreateAccountDto;
import com.github.copy.bookstore.ohs.resource.dto.ModifyAccountDto;
import org.mapstruct.Mapper;

/**
 * 用户聚合 dto转换器
 * @author 素律
 * @since 2021/4/1 7:40 下午
 */
@Mapper(componentModel = "spring")
public interface AccountDtoConv {
    /**
     * dto转用户 写参数
     * @param  createAccountDto 创建用户信息 DTO
     * @return 用户 参数
     */
    AccountWriteParam dto2WriteParam(CreateAccountDto createAccountDto);
    /**
     * dto转用户 写参数
     * @param  modifyAccountDto 修改用户信息 DTO
     * @return 用户 参数
     */
    AccountWriteParam dto2WriteParam(ModifyAccountDto modifyAccountDto);

    /**
     * 领域实体转dto
     * @param  account 用户 实体
     * @return 用户信息 DTO
     */
    AccountDto entity2Dto(Account account);
}
