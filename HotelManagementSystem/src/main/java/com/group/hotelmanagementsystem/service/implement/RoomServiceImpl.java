package com.group.hotelmanagementsystem.service.implement;

import com.group.hotelmanagementsystem.entity.Room;
import com.group.hotelmanagementsystem.mapper.RoomMapper;
import com.group.hotelmanagementsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public int deleteByPrimaryKey(Integer roomID) {
        return roomMapper.deleteByPrimaryKey(roomID);
    }

    @Override
    public int insert(Room record) {
        return roomMapper.insert(record);
    }

    @Override
    public int insertSelective(Room record) {
        return roomMapper.insertSelective(record);
    }

    @Override
    public Room selectByPrimaryKey(Integer roomID) {
        return roomMapper.selectByPrimaryKey(roomID);
    }

    @Override
    public List<Room> selectByRoomByTypeID(Integer roomYTypeID) {
        return roomMapper.selectByRoomTypeID(roomYTypeID);
    }

    @Override
    public List<Room> selectByRoomStatusIDAndRoomTypeID(Room room) {
        return roomMapper.selectByRoomStatusIDAndRoomTypeID(room);
    }

    @Override
    public int updateByPrimaryKeySelective(Room record) {
        return roomMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Room record) {
        return roomMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Room> selectAll() {
        return roomMapper.selectAll();
    }

    @Override
    public int alterTable() {
        return roomMapper.alterTable();
    }
}
