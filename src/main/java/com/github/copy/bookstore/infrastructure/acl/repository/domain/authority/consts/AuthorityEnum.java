package com.github.copy.bookstore.infrastructure.acl.repository.domain.authority.consts;

import com.github.copy.bookstore.domain.aggregation.authority.entity.Authority;
import lombok.Getter;

/**
 * 权限枚举
 * @author Jxin
 * @since 2021/4/7 9:35 下午
 */
public enum AuthorityEnum {
    ;
    @Getter
    private Authority authority;

    AuthorityEnum(String authority) {
        this.authority = Authority.of(authority);
    }
}
