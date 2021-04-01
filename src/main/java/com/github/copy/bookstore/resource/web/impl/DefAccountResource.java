package com.github.copy.bookstore.resource.web.impl;

import com.github.copy.bookstore.resource.global.JaxrsRsp;
import com.github.copy.bookstore.resource.web.AccountResource;
import com.github.copy.bookstore.resource.web.dto.AccountDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

/**
 * 用户资源层 基于Jersey的web实现
 * @author Jxin
 * @since 2021/3/31 11:48 上午
 */
@Slf4j
@RestController
@RequestMapping("/accounts")
public class DefAccountResource implements AccountResource {
    @GetMapping("/{username}")
    @Override
    public AccountDto getUser(@PathVariable("username") String username) {
        log.info("查询用户, 入参:{}", username);
        return new AccountDto();
    }
    @PostMapping
    @Override
    public Response createUser(@RequestBody AccountDto user) {
        return JaxrsRsp.op(() -> log.info("创建用户成功, 入参:{}", user));
    }
    @PutMapping
    @Override
    public Response modifyUser(@RequestBody AccountDto user) {
        return JaxrsRsp.op(() -> log.info("更新用户成功, 入参:{}", user));
    }
}
