package com.mofei.service.serviceimpl;

import com.mofei.constant.StatusCodeConstant;
import com.mofei.mapper.AccountMapper;
import com.mofei.mapper.PropertyMapper;
import com.mofei.mapper.TransactionRecordMapper;
import com.mofei.pojo.Account;
import com.mofei.pojo.Property;
import com.mofei.pojo.TransactionRecord;
import com.mofei.service.AccountService;
import com.mofei.service.PropertyService;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("accountService")
public class AccountServiceimpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    TransactionRecordMapper transactionRecordMapper;

    @Override
    public boolean existsCardNo(String cardNo) {
        int count  = accountMapper.existsCardNo(cardNo);
        return count == 1? true : false;
    }

    @Override
    public Account login(Account account) {
        Account account1 =  accountMapper.queryByCardNopwd(account.getCardNo(),account.getPassword());
        return account1;
    }

    @Override
    public double queryBalance(String cardNo) {
        return accountMapper.queryBalance(cardNo);
    }

    @Override
    public Map<String, Object> transfer(Account sourceAccount, String cardNo, Double transactionAmount) {
        Map<String , Object> map = new HashMap<>();

        int code = StatusCodeConstant.NO_EXISTS;
        String msg = StatusCodeConstant.NO_EXISTS_MSG;

        //1检查账号是否存在，不存在直接失则
        int row = accountMapper.existsCardNo(cardNo);
        if (row == 1){
            //代表目标账号存在
            code = StatusCodeConstant.EXISTS;
            //2账号存在，是否被冻结
            row = accountMapper.freeZon(cardNo);
            if (row==1) {
                //激活
                //激活的花code可以不用赋值的

                //3账号存在，激活，但是10 100万，也不行
                //检查余额够不够,应该检查原来的,
                row = accountMapper.balanceEnouch(sourceAccount.getCardNo(),transactionAmount);
                if (row == 1) {
                    //余额够
                    //4转账成功，必须一方加钱成功，另一方减钱成功。

                    // 第一步，目标账号+钱
                    accountMapper.plus(cardNo,transactionAmount);
                    // 第二步，目标账号-钱
                    accountMapper.minus(sourceAccount.getCardNo(),transactionAmount);
                    // 第三部，产生交易记录
                    TransactionRecord tr = new TransactionRecord();
                    tr.setCardNo(sourceAccount.getCardNo());
                    tr.setTransactionAmount(transactionAmount);
                    tr.setTransactionType("转账");
                    tr.setTransactionDate(new Date());
                    //重新查询
                    double balance = accountMapper.queryBalance(sourceAccount.getCardNo());
                    tr.setBalance(balance);

                    row =  transactionRecordMapper.insert(tr);
                    if (row == 1) {
                        code = StatusCodeConstant.SUCCESS;
                        msg = StatusCodeConstant.SUCCESS_MSG;
                    }
                }else {
                    //余额不够
                    code = StatusCodeConstant.BALANCE_NOT_ENOUGH;
                    msg = StatusCodeConstant.BALANCE_NOT_ENOUGH_MSG;
                }
            }else {
                //冻结
                code = StatusCodeConstant.FREERON;
                msg = StatusCodeConstant.FREERON_MSG;
            }
        }else {
            //代表目标账号不存在
            //默认不存在,不用在设置不存,其实无需额外处理
        }
        map.put("code",code);
        map.put("msg",msg);
        return map;
    }
}