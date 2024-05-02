package com.group.hotelmanagementsystem.service.implement;

import com.group.hotelmanagementsystem.entity.CheckInRecord;
import com.group.hotelmanagementsystem.mapper.CheckInRecordMapper;
import com.group.hotelmanagementsystem.service.CheckInRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckInRecordServiceImpl implements CheckInRecordService {

    @Autowired
    private CheckInRecordMapper checkInRecordMapper;


    @Override
    public int deleteByPrimaryKey(Integer checkInRecordID) {
        return checkInRecordMapper.deleteByPrimaryKey(checkInRecordID);
    }

    @Override
    public int insert(CheckInRecord record) {
        return checkInRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(CheckInRecord record) {
        return checkInRecordMapper.insertSelective(record);
    }

    @Override
    public CheckInRecord selectByPrimaryKey(Integer checkInRecordID) {
        return checkInRecordMapper.selectByPrimaryKey(checkInRecordID);
    }

    @Override
    public List<CheckInRecord> selectAll() {
        return checkInRecordMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKeySelective(CheckInRecord record) {
        return checkInRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CheckInRecord record){
        return checkInRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public int alterTable() {
        return checkInRecordMapper.alterTable();
    }

    ;
}
