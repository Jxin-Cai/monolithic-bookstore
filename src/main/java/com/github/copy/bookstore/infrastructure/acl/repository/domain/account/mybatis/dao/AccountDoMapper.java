package com.github.copy.bookstore.infrastructure.acl.repository.domain.account.mybatis.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.github.copy.bookstore.infrastructure.acl.repository.domain.account.table.AccountDo;

/**
 *
 * @author Jxin
 * @since 2021/4/1 8:41 下午
 */
public interface AccountDoMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(AccountDo record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(AccountDo record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    AccountDo selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(AccountDo record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(AccountDo record);

    /**
     * 根据账号获取用户do
     * @param  username 账号
     * @return 用户do
     */
    AccountDo getByUsername(@Param("username")String username);

    /**
     * 查询用户do列表
     * @param  username  账号
     * @param  telephone 电话
     * @param  email     email
     * @return 符合条件的用户do列表
     */
    List<AccountDo> findByUsernameOrTelephoneOrEmail(@Param("username")String username,@Param("telephone")String telephone,@Param("email")String email);



}