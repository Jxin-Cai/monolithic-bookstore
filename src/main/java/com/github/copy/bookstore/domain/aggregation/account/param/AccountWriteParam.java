package com.github.copy.bookstore.domain.aggregation.account.param;

import lombok.Data;

/**
 * 用户 写参数
 * @author 素律
 * @since 2021/4/1 5:34 下午
 */
@Data
public class AccountWriteParam {
    /**id*/
    private Integer id;
    /**账户*/
    private String username;
    /**密码*/
    private String password;
    /**姓名*/
    private String name;
    /**头像*/
    private String avatar;
    /**电话*/
    private String telephone;
    /**邮箱*/
    private String email;
    /**地址*/
    private String location;
}
