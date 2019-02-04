package com.mofei.service.serviceimpl;

import com.mofei.mapper.EntryMapper;
import com.mofei.mapper.PropertyMapper;
import com.mofei.pojo.Entry;
import com.mofei.pojo.Property;
import com.mofei.service.EntryService;
import com.mofei.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("entryService")
public class EntryServiceimpl implements EntryService {

    @Autowired
    EntryMapper entryMapper;

    @Override
    public List<Entry> querylist(Integer cid) {
        return entryMapper.querylist(cid);
    }

    @Override
    public int add(Entry entry) {
        return entryMapper.add(entry);
    }


}