package com.mofei.mapper;


import com.mofei.dto.RecordDTO;
import com.mofei.pojo.TransactionRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TransactionRecordMapper {


    public int insert(@Param("tr") TransactionRecord tr);

//    List<TransactionRecord> queryByCardNo(@Param("cardNo") String cardNo, @Param("start") Date start, Date end);
    List<TransactionRecord> queryByCardNo(@Param("recordDTO") RecordDTO recordDTO);
}