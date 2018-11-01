package com.coo.web.controller;

import com.coo.dao.model.User;
import com.coo.rec.api.IAccountService;
import com.coo.rec.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by aa on 2018/11/1.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/addAndUpdateUser" , method = RequestMethod.POST )
    @ResponseBody
    public Object addAndUpdateUser( User user){

        int result = 0;
        if( user.getUserId() == null ){
            result = userService.addUser(user);
        }else{
            result = userService.updateUser(user);
        }
        if( result < 1 ){
            return "faild";
        }
        return "success";
    }

    @RequestMapping(value = "/deleteUser" , method = RequestMethod.POST )
    @ResponseBody
    public Object deleteUser( Integer userId){

        int result = userService.deleteUser( userId );
        if( result < 1 ){
            return "faild";
        }
        return "success";
    }

    @RequestMapping(value = "/selectOne" , method = RequestMethod.GET )
    @ResponseBody
    public Object seleteOne( Integer userId){

        User result = userService.selectOne( userId );
        if( result == null){
            return "faild";
        }
        return result;
    }


    @RequestMapping(value = "/seleteAll" , method = RequestMethod.GET )
    @ResponseBody
    public Object seleteAll( ){

        List<User> result = userService.selectAll(  );
        if( result == null){
            return "faild";
        }
        return result;
    }




}
