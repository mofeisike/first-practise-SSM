package com.mofei.service;


import com.mofei.pojo.Account;
import com.mofei.pojo.Entry;

import java.util.List;
import java.util.Map;

public interface AccountService {


    boolean existsCardNo(String cardNo);


    Account login(Account account);

    double queryBalance(String cardNo);

    Map<String,Object> transfer(Account sourceAccount, String cardNo,Double transactionAmount);

}