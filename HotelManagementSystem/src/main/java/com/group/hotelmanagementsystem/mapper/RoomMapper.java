package com.group.hotelmanagementsystem.mapper;

import com.group.hotelmanagementsystem.entity.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {
    int deleteByPrimaryKey(Integer roomID);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer roomID);

    List<Room> selectByRoomTypeID(Integer roomTypeID);

    List<Room> selectByRoomStatusIDAndRoomTypeID(Room room);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    List<Room> selectAll();

    int alterTable();
}