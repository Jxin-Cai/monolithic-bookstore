package com.github.copy.bookstore.infrastructure.acl.repository.domain.authority;

import com.github.copy.bookstore.domain.aggregation.authority.acl.repository.RoleRepository;
import com.github.copy.bookstore.domain.aggregation.authority.entity.Role;
import com.github.copy.bookstore.infrastructure.acl.repository.domain.authority.consts.AuthorityEnum;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 角色仓库 内存实现
 * @author Jxin
 * @since 2021/4/7 9:49 下午
 */
@Repository
public class InMemoryRoleRepository implements RoleRepository {
    private static final Map<Integer, Role> MEMORY;
    static {
        MEMORY = Maps.newHashMap();
        final Role admin = new Role();
        admin.setAuthorities(
                Arrays.stream(AuthorityEnum.values())
                      .map(AuthorityEnum::getAuthority)
                      .collect(Collectors.toList()));
        MEMORY.put(1, admin);
    }
    @Override
    public Role get(Integer id) {
        return MEMORY.get(id);
    }
}
