package com.group.hotelmanagementsystem.service;

import com.group.hotelmanagementsystem.entity.RoomType;

import java.util.List;

public interface RoomTypeService {
    int deleteByPrimaryKey(Integer roomTypeID);

    int insert(RoomType record);

    int insertSelective(RoomType record);

    RoomType selectByPrimaryKey(Integer roomTypeID);

    int updateByPrimaryKeySelective(RoomType record);

    int updateByPrimaryKey(RoomType record);

    List<RoomType> selectAll();

    int alterTable();
}
