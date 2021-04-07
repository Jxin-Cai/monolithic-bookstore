package com.github.copy.bookstore.infrastructure.acl.repository.err;

import cn.hutool.core.util.StrUtil;

/**
 * db写异常
 * @author Jxin
 * @since 2021/4/1 8:58 下午
 */
public class DbWriteException extends RuntimeException{
    private static final long serialVersionUID = -127088082726297789L;
    public DbWriteException(Throwable e) {
        super(StrUtil.format("{}: {}", e.getClass().getSimpleName(), e.getMessage()), e);
    }

    public DbWriteException(String messageTemplate, Object... params) {
        super(StrUtil.format(messageTemplate, params));
    }

    public DbWriteException(Throwable throwable, String messageTemplate, Object... params) {
        super(StrUtil.format(messageTemplate, params), throwable);
    }
}
