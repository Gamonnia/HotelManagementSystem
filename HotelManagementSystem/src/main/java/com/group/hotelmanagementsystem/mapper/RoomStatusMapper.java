package com.group.hotelmanagementsystem.mapper;

import com.group.hotelmanagementsystem.entity.RoomStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomStatusMapper {
    int deleteByPrimaryKey(Integer roomStatusID);

    int insert(RoomStatus record);

    int insertSelective(RoomStatus record);

    RoomStatus selectByPrimaryKey(Integer roomStatusID);

    int updateByPrimaryKeySelective(RoomStatus record);

    int updateByPrimaryKey(RoomStatus record);

    List<RoomStatus> selectAll();

    int alterTable();
}