package com.mofei.mapper;


import com.mofei.pojo.Property;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PropertyMapper {

    public int add(@Param("property") Property property);

    public void delete(@Param("id")int id);

    public int update(@Param("property") Property property);

    public Property get(@Param("id") int id);

    public List<Property> list(@Param("id") int id);

}