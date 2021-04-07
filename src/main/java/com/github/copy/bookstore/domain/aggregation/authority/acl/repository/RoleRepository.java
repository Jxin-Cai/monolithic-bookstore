package com.github.copy.bookstore.domain.aggregation.authority.acl.repository;

import com.github.copy.bookstore.domain.aggregation.authority.entity.Role;

/**
 * 角色仓库
 * @author Jxin
 * @since 2021/4/7 9:49 下午
 */
public interface RoleRepository {
    /**
     * 根据id获取角色实体
     * @param  id id
     * @return 角色实体
     */
    Role get(Integer id);
}
