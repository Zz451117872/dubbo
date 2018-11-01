package com.coo.dao.mapper;

import com.coo.dao.model.Account;
import com.coo.dao.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by aa on 2018/11/1.
 */
@Mapper
public interface AccountMapper {


    @Insert("insert into account(accountId,amount,version) values(#{accountId},#{amount},#{version})")
    int insert( Account account);

    @Update("update account set amount=#{amount}, version=#{version} where accountId=#{accountId}")
    int update( Account account);

    @Delete("delete from account where accountId = #{accountId}")
    int delete( Integer accountId);

    @Select("select * from account where accountId=#{accountId}")
    @Results(
            {
                    @Result( property = "accountId" , column = "accountId" , id = true),
                    @Result( property = "amount" , column = "amount" ),
                    @Result( property = "version" , column = "version" )
            }
    )
    Account selectOne( Integer accountId);

    @Select("select * from account where 1=1")
    @Results(
            {
                    @Result( property = "accountId" , column = "accountId" , id = true),
                    @Result( property = "amount" , column = "amount" ),
                    @Result( property = "version" , column = "version" )
            }
    )
    List<Account> selectAll( );

}
