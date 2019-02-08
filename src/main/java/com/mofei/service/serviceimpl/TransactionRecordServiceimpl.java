package com.mofei.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mofei.dto.RecordDTO;
import com.mofei.mapper.TransactionRecordMapper;
import com.mofei.pojo.TransactionRecord;
import com.mofei.service.AccountService;
import com.mofei.service.TransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Service("transactionRecordService")
public class TransactionRecordServiceimpl implements TransactionRecordService {


    @Autowired
    private TransactionRecordMapper transactionRecordMapper;

    @Override
    public PageInfo<TransactionRecord> queryByCardNo(RecordDTO recordDTO) {
        //起始的位置,就是当前的页数,
        PageHelper.startPage(recordDTO.getPageNum(),recordDTO.getPageSize());
        List<TransactionRecord> l = transactionRecordMapper.queryByCardNo(recordDTO);
        PageInfo<TransactionRecord> page = new PageInfo<>(l);
        return page;
    }
}