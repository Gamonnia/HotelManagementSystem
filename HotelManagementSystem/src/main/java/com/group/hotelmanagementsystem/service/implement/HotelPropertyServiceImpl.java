package com.group.hotelmanagementsystem.service.implement;


import com.group.hotelmanagementsystem.entity.HotelProperty;
import com.group.hotelmanagementsystem.mapper.HotelPropertyMapper;
import com.group.hotelmanagementsystem.service.HotelPropertyService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelPropertyServiceImpl implements HotelPropertyService {

    private final HotelPropertyMapper hotelPropertyMapper;

    public HotelPropertyServiceImpl(HotelPropertyMapper hotelPropertyMapper) {
        this.hotelPropertyMapper = hotelPropertyMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer departmentID) {
        return hotelPropertyMapper.deleteByPrimaryKey(departmentID);
    }

    @Override
    public int insert(HotelProperty record) {
        return hotelPropertyMapper.insert(record);
    }

    @Override
    public int insertSelective(HotelProperty record){
        return hotelPropertyMapper.insertSelective(record);
    }

    @Override
    public HotelProperty selectByPrimaryKey(Integer itemID){
        return hotelPropertyMapper.selectByPrimaryKey(itemID);
    }

    @Override
    public int updateByPrimaryKeySelective(HotelProperty record){
        return hotelPropertyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HotelProperty record){
        return hotelPropertyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<HotelProperty> selectAll() {
        return hotelPropertyMapper.selectAll();
    }

    @Override
    public int alterTable() {
        return hotelPropertyMapper.alterTable();
    }


}
