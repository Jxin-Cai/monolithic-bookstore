package com.github.copy.bookstore.domain.aggregation.authority.entity;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色 实体
 * @author Jxin
 * @since 2021/4/7 9:31 下午
 */
@Data
public class Role {
    /**角色名称*/
    private String name;
    /**权力列表*/
    private List<Authority> authorities;

    /**
     * 获取角色的权限列表
     * @return 权限列表
     */
    public List<String> authorities(){
        return authorities.stream().map(Authority::getValue).collect(Collectors.toList());
    }
}
