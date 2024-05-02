package com.group.hotelmanagementsystem.service;

import com.group.hotelmanagementsystem.entity.RoomStatus;

import java.util.List;

public interface RoomStatusService {
    int deleteByPrimaryKey(Integer roomStatusID);

    int insert(RoomStatus record);

    int insertSelective(RoomStatus record);

    RoomStatus selectByPrimaryKey(Integer roomStatusID);

    int updateByPrimaryKeySelective(RoomStatus record);

    int updateByPrimaryKey(RoomStatus record);

    List<RoomStatus> selectAll();

    int alterTable();
}
