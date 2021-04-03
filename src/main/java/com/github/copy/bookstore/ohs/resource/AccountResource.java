package com.github.copy.bookstore.ohs.resource;

import com.github.copy.bookstore.ohs.resource.dto.AccountDto;
import com.github.copy.bookstore.ohs.resource.dto.CreateAccountDto;
import com.github.copy.bookstore.ohs.resource.dto.ModifyAccountDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.core.Response;





/**
 * 用户资源接口
 * @author Jxin
 * @since 2021/3/30 2:20 下午
 */

@Api(tags = "用户资源接口")
public interface AccountResource {
    /**
     * 根据用户名称获取用户详情
     * @param  username 账户名
     * @return 用户信息 DTO
     */
    @ApiOperation(value = "根据用户名称获取用户详情", response = CreateAccountDto.class)
    AccountDto getUser(String username);
    /**
     * 创建新的用户
     * @param  user 用户信息 DTO
     * @return 全局返回参数, 成功entity=true
     */
    @ApiOperation(value = "创建新的用户", response = Response.class)
    Response createUser(CreateAccountDto user);

    /**
     * 更新用户信息
     * @param  user 用户信息 DTO
     * @return 全局返回参数, 成功entity=true
     */
    @ApiOperation(value = "更新用户信息", response = Response.class)
    Response modifyUser(ModifyAccountDto user);
}
