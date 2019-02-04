package com.mofei.mapper;


import com.mofei.pojo.Entry;
import com.mofei.pojo.Property;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EntryMapper {


    public List<Entry> querylist(@Param("cid") Integer cid);
    
    int add(@Param("entry") Entry entry);
}