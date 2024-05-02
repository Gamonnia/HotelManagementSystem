package com.group.hotelmanagementsystem.service.implement;

import com.group.hotelmanagementsystem.entity.FinancialRecord;
import com.group.hotelmanagementsystem.mapper.FinancialRecordMapper;
import com.group.hotelmanagementsystem.service.FinancialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialRecordServiceImpl implements FinancialRecordService {

    @Autowired private FinancialRecordMapper financialRecordMapper;

    @Override
    public int deleteByPrimaryKey(Integer financialRecordID) {
        return financialRecordMapper.deleteByPrimaryKey(financialRecordID);
    }

    @Override
    public int insert(FinancialRecord record) {
        return financialRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(FinancialRecord record) {
        return financialRecordMapper.insertSelective(record);
    }

    @Override
    public FinancialRecord selectByPrimaryKey(Integer financialRecordID) {
        return financialRecordMapper.selectByPrimaryKey(financialRecordID);
    }

    @Override
    public int updateByPrimaryKeySelective(FinancialRecord record) {
        return financialRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FinancialRecord record) {
        return financialRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FinancialRecord> selectAll() {
        return financialRecordMapper.selectAll();
    }

    @Override
    public int alterTable() {
        return financialRecordMapper.alterTable();
    }
}
