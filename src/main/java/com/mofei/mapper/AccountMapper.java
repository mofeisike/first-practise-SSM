package com.mofei.mapper;


import com.mofei.pojo.Account;
import com.mofei.pojo.Property;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AccountMapper {

    //查账户
    int existsCardNo(@Param("cardNo") String cardNo);

    //查密码
    Account queryByCardNopwd(@Param("cardNo") String cardNo, @Param("password") String password);

    double queryBalance(@Param("cardNo") String cardNo);

    /*
    返回1代表未冻结
    返回0代表冻结
    * */
    int freeZon(@Param("cardNo") String cardNo);

    /*
    检查cardNo对应的账号要转出transactionAmount是否够
     */
    int balanceEnouch(@Param("cardNo") String cardNo, @Param("transactionAmount") Double transactionAmount);


    void plus(@Param("cardNo") String cardNo, @Param("transactionAmount") Double transactionAmount);


    void minus(@Param("cardNo") String cardNo, @Param("transactionAmount") Double transactionAmount);
}