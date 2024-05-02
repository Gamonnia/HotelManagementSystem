package com.group.hotelmanagementsystem.service;

import com.group.hotelmanagementsystem.entity.HotelProperty;

import java.util.List;

public interface HotelPropertyService {
    int deleteByPrimaryKey(Integer itemID);

    int insert(HotelProperty record);

    int insertSelective(HotelProperty record);

    HotelProperty selectByPrimaryKey(Integer itemID);

    int updateByPrimaryKeySelective(HotelProperty record);

    int updateByPrimaryKey(HotelProperty record);

    List<HotelProperty> selectAll();

    int alterTable();
}
