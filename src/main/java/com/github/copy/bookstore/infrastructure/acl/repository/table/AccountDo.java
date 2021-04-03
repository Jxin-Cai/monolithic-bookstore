package com.github.copy.bookstore.infrastructure.acl.repository.table;

import lombok.Data;

/**
 *
 * @author 素律
 * @since 2021/4/1 8:41 下午
 */
@Data
public class AccountDo {
    private Integer id;

    private String username;

    private String password;

    private String name;

    private String avatar;

    private String telephone;

    private String email;

    private String location;
}