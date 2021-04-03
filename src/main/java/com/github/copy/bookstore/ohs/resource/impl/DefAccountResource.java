package com.github.copy.bookstore.ohs.resource.impl;

import com.github.copy.bookstore.application.assembler.AccountDtoConv;
import com.github.copy.bookstore.application.service.AccountManager;
import com.github.copy.bookstore.domain.aggregation.account.entity.Account;
import com.github.copy.bookstore.domain.aggregation.account.param.AccountReadParam;
import com.github.copy.bookstore.domain.aggregation.account.param.AccountWriteParam;
import com.github.copy.bookstore.ohs.global.JaxrsRsp;
import com.github.copy.bookstore.ohs.resource.AccountResource;
import com.github.copy.bookstore.ohs.resource.dto.AccountDto;
import com.github.copy.bookstore.ohs.resource.dto.CreateAccountDto;
import com.github.copy.bookstore.ohs.resource.dto.ModifyAccountDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * 用户资源层 基于Jersey的web实现
 * @author Jxin
 * @since 2021/3/31 11:48 上午
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class DefAccountResource implements AccountResource {
    private final AccountManager accountManager;
    private final AccountDtoConv accountDtoConv;
    @GetMapping("/{username}")
    @Override
    public AccountDto getUser(@PathVariable("username") @NotNull String username) {
        log.info("查询用户, 入参:{}", username);
        final Account user = accountManager.getUser(AccountReadParam.of(username));
        return Optional.ofNullable(user)
                       .map(accountDtoConv::entity2Dto)
                       .orElse(null);
    }
    @PostMapping
    @Override
    public Response createUser(@Validated @RequestBody CreateAccountDto user) {
        final AccountWriteParam accountWriteParam = accountDtoConv.dto2WriteParam(user);
        return JaxrsRsp.op(() -> accountManager.createUser(accountWriteParam));
    }
    @PutMapping
    @Override
    public Response modifyUser(@Validated @RequestBody ModifyAccountDto user) {
        final AccountWriteParam accountWriteParam = accountDtoConv.dto2WriteParam(user);
        return JaxrsRsp.op(() -> accountManager.modifyUser(accountWriteParam));
    }
}
