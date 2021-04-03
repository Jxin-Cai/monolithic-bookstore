package com.github.copy.bookstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 书店项目启动类
 * @author Jxin
 * @since 2021/3/30 3:19 下午
 */
@MapperScan("com.github.copy.bookstore.infrastructure.acl.repository.mybatis.dao")
@SpringBootApplication
// @EnableCaching
//@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class BookstoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }
}
