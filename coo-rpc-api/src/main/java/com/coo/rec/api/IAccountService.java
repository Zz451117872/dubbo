package com.coo.rec.api;

import com.coo.dao.model.Account;

import java.util.List;

/**
 * Created by aa on 2018/11/1.
 */
public interface IAccountService {

    int addAccount( Account account);

    int updateAccount( Account account);

    int deleteAccount( Integer accountId);

    Account selectOne(Integer accountId);

    List<Account> selectAll();
}
