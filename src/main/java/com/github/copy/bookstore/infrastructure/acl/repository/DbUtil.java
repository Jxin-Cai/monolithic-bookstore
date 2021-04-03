package com.github.copy.bookstore.infrastructure.acl.repository;

import com.github.copy.bookstore.infrastructure.acl.repository.err.DbWriteException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * db操作的一些工具
 * @author 素律
 * @since 2021/4/1 9:03 下午
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public final class DbUtil {

    /**
     * 执行操作
     * 封装了isOne的返回校验，不满足抛异常, 用于简化编码
     */
    public static void opIsOne(Supplier<Integer> supplier) {
        op(supplier, i -> i == 1, e -> log.error(e.getMessage(), e));
    }
    /**
     * 校验操作
     * 封装了isOne的返回校验，用于简化编码
     */
    public static boolean testIsOne(Supplier<Integer> supplier) {
        return test(supplier, i -> i == 1);
    }

    /**
     * 执行操作（带自定义的失败处理）
     * 用于简化编码
     */
    public static <T> void op(Supplier<T> supplier, Predicate<T> predicate, Consumer<Exception> exceptionConsumer) {
        try {
            final boolean test = test(supplier, predicate);
            if(!test){
                throw new DbWriteException("写操作出现异常，执行数据行数不为1");
            }
        } catch (Exception e) {
            exceptionConsumer.accept(e);
        }
    }

    /**
     * 校验操作
     * 用于简化编码
     */
    public static <T> boolean test(Supplier<T> supplier, Predicate<T> predicate) {
         return predicate.test(supplier.get());
    }
}
