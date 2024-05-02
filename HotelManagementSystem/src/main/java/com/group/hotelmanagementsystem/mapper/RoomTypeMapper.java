package com.group.hotelmanagementsystem.mapper;

import com.group.hotelmanagementsystem.entity.RoomType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomTypeMapper {
    int deleteByPrimaryKey(Integer roomTypeID);

    int insert(RoomType record);

    int insertSelective(RoomType record);

    RoomType selectByPrimaryKey(Integer roomTypeID);

    int updateByPrimaryKeySelective(RoomType record);

    int updateByPrimaryKey(RoomType record);

    List<RoomType> selectAll();

    int alterTable();
}