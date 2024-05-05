package com.group.hotelmanagementsystem.service.implement;

import com.group.hotelmanagementsystem.entity.RoomType;
import com.group.hotelmanagementsystem.mapper.RoomTypeMapper;
import com.group.hotelmanagementsystem.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeMapper roomTypeMapper;

    @Override
    public int deleteByPrimaryKey(Integer roomTypeID) {
        return roomTypeMapper.deleteByPrimaryKey(roomTypeID);
    }

    @Override
    public int insert(RoomType record) {
        return roomTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(RoomType record) {
        return roomTypeMapper.insertSelective(record);
    }

    @Override
    public RoomType selectByPrimaryKey(Integer roomTypeID) {
        return roomTypeMapper.selectByPrimaryKey(roomTypeID);
    }

    @Override
    public RoomType selectByRoomTypeName(String roomTypeName) {
        return roomTypeMapper.selectByRoomTypeName(roomTypeName);
    }

    @Override
    public int updateByPrimaryKeySelective(RoomType record) {
        return roomTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoomType record) {
        return roomTypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<RoomType> selectAll() {
        return roomTypeMapper.selectAll();
    }

    @Override
    public int alterTable() {
        return roomTypeMapper.alterTable();
    }
}
