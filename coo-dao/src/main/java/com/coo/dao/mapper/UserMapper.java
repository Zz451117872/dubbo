package com.coo.dao.mapper;

import com.coo.dao.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by aa on 2018/11/1.
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(name,password,version) values(#{name},#{password},#{version})")
    int insert( User user);

    @Update("update user set name=#{name}, password=#{password}, version=#{version} where userId=#{userId}")
    int update( User user);

    @Delete("delete from user where userId = #{userId}")
    int delete( Integer user);

    @Select("select * from user where userId=#{userId}")
    @Results(
            {
                    @Result( property = "userId" , column = "userId" , id = true),
                    @Result( property = "name" , column = "name" ),
                    @Result( property = "password" , column = "password" ),
                    @Result( property = "version" , column = "version" )
            }
    )
    User selectOne( Integer userId);

    @Select("select * from user where 1=1")
    @Results(
            {
                    @Result( property = "userId" , column = "userId" , id = true),
                    @Result( property = "name" , column = "name" ),
                    @Result( property = "password" , column = "password" ),
                    @Result( property = "version" , column = "version" )
            }
    )
    List<User> selectAll( );
}
