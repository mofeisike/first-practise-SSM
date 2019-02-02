package com.mofei.service;


import com.mofei.pojo.Category;
import com.mofei.pojo.Entry;
import com.mofei.pojo.Property;

import java.util.List;

public interface EntryService {


    List<Entry> querylist(Integer cid);


}