package com.github.copy.bookstore.domain.aggregation.authority.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 权力 实体
 * @author Jxin
 * @since 2021/4/7 9:32 下午
 */
@Data
@AllArgsConstructor
public class Authority {
    /**表示权力的值*/
    private final String value;

    public static Authority of(String authority){
        return new Authority(authority);
    }
}
