package com.group.hotelmanagementsystem.service;

import com.group.hotelmanagementsystem.entity.Room;

import java.util.List;

public interface RoomService {
    int deleteByPrimaryKey(Integer roomID);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer roomID);

    List<Room> selectByRoomByTypeID(Integer roomYTypeID);

    List<Room> selectByRoomStatusIDAndRoomTypeID(Room room);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    List<Room> selectAll();

    int alterTable();
}
