package com.group.hotelmanagementsystem.mapper;

import com.group.hotelmanagementsystem.entity.HotelProperty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HotelPropertyMapper {
    int deleteByPrimaryKey(Integer itemID);

    int insert(HotelProperty record);

    int insertSelective(HotelProperty record);

    HotelProperty selectByPrimaryKey(Integer itemID);

    int updateByPrimaryKeySelective(HotelProperty record);

    int updateByPrimaryKey(HotelProperty record);

    List<HotelProperty> selectAll();

    int alterTable();
}