package com.mofei.service;


import com.mofei.pojo.Category;
import com.mofei.pojo.Property;

import java.util.List;

public interface PropertyService {


    void update(Property Property);

    void detele(Property property);

    void add(Property property);

    Property get(int id);

    List<Property> list(int id);

}