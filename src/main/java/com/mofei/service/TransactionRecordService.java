package com.mofei.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mofei.dto.RecordDTO;
import com.mofei.pojo.TransactionRecord;

import java.util.Date;
import java.util.List;

public interface TransactionRecordService {


    PageInfo<TransactionRecord> queryByCardNo(RecordDTO recordDTO);
}