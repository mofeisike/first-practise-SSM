package com.mofei.service.serviceimpl;

import com.mofei.mapper.PropertyMapper;
import com.mofei.pojo.Category;
import com.mofei.pojo.Property;
import com.mofei.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("propertyService")
public class PropertyServiceimpl implements PropertyService {


    @Autowired
    PropertyMapper propertyMapper;

    @Override
    public void add(Property property) {
        propertyMapper.add(property);
    }

    @Override
    public void detele(Property property) {
        propertyMapper.delete(property.getId());
    }

    @Override
    public void update(Property property) {
        propertyMapper.update(property);
    }

    @Override
    public Property get(int id) {
        return propertyMapper.get(id);
    }

    @Override
    public List<Property> list(int id) {
        return propertyMapper.list(id);
    }


}