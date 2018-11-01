package com.coo.web.controller;

import com.coo.dao.model.Account;
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
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/addAndUpdateAccount" , method = RequestMethod.POST )
    @ResponseBody
    public Object addAndUpdateAccount( Account account){

        int result = 0;
        if( account.getAccountId() == null ){
            result = accountService.addAccount(account);
        }else{
            result = accountService.updateAccount(account);
        }
        if( result < 1 ){
            return "faild";
        }
        return "success";
    }

    @RequestMapping(value = "/deleteAccount" , method = RequestMethod.POST )
    @ResponseBody
    public Object deleteAccount( Integer accountId){

        int result = accountService.deleteAccount( accountId );
        if( result < 1 ){
            return "faild";
        }
        return "success";
    }

    @RequestMapping(value = "/selectOne" , method = RequestMethod.GET )
    @ResponseBody
    public Object seleteOne( Integer accountId){

        Account result = accountService.selectOne( accountId );
        if( result == null){
            return "faild";
        }
        return result;
    }


    @RequestMapping(value = "/seleteAll" , method = RequestMethod.GET )
    @ResponseBody
    public Object seleteAll( ){

        List<Account> result = accountService.selectAll(  );
        if( result == null){
            return "faild";
        }
        return result;
    }


}
