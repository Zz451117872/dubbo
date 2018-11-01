package com.coo.rec.api;

import com.coo.dao.model.Account;
import com.coo.dao.model.User;

import java.util.List;

/**
 * Created by aa on 2018/11/1.
 */
public interface IUserService {

    int addUser( User user);

    int updateUser( User user);

    int deleteUser( Integer userId);

    User selectOne(Integer userId);

    List<User> selectAll();
}
