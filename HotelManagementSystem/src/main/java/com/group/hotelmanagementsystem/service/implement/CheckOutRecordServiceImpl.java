package com.group.hotelmanagementsystem.service.implement;

import com.group.hotelmanagementsystem.entity.CheckOutRecord;
import com.group.hotelmanagementsystem.mapper.CheckOutRecordMapper;
import com.group.hotelmanagementsystem.service.CheckOutRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckOutRecordServiceImpl implements CheckOutRecordService {

    @Autowired
    private CheckOutRecordMapper checkOutRecordMapper;

    @Override
    public int deleteByPrimaryKey(Integer checkOutRecordID) {
        return checkOutRecordMapper.deleteByPrimaryKey(checkOutRecordID);
    }

    @Override
    public int insert(CheckOutRecord record) {
        return checkOutRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(CheckOutRecord record) {
        return checkOutRecordMapper.insertSelective(record);
    }

    @Override
    public CheckOutRecord selectByPrimaryKey(Integer checkOutRecordID) {
        return checkOutRecordMapper.selectByPrimaryKey(checkOutRecordID);
    }

    @Override
    public int updateByPrimaryKeySelective(CheckOutRecord record) {
        return checkOutRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CheckOutRecord record) {
        return checkOutRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CheckOutRecord> selectAll() {
        return checkOutRecordMapper.selectAll();
    }

    @Override
    public int alterTable() {
        return checkOutRecordMapper.alterTable();
    }
}
