package com.group.hotelmanagementsystem.service.implement;

import com.group.hotelmanagementsystem.entity.RoomStatus;
import com.group.hotelmanagementsystem.mapper.RoomStatusMapper;
import com.group.hotelmanagementsystem.service.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomStatusServiceImpl implements RoomStatusService {

    @Autowired
    private RoomStatusMapper roomStatusMapper;

    @Override
    public int deleteByPrimaryKey(Integer roomStatusID) {
        return roomStatusMapper.deleteByPrimaryKey(roomStatusID);
    }

    @Override
    public int insert(RoomStatus record) {
        return roomStatusMapper.insert(record);
    }

    @Override
    public int insertSelective(RoomStatus record) {
        return roomStatusMapper.insertSelective(record);
    }

    @Override
    public RoomStatus selectByPrimaryKey(Integer roomStatusID) {
        return roomStatusMapper.selectByPrimaryKey(roomStatusID);
    }

    @Override
    public int updateByPrimaryKeySelective(RoomStatus record) {
        return roomStatusMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoomStatus record) {
        return roomStatusMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<RoomStatus> selectAll() {
        return roomStatusMapper.selectAll();
    }

    @Override
    public int alterTable() {
        return roomStatusMapper.alterTable();
    }
}
