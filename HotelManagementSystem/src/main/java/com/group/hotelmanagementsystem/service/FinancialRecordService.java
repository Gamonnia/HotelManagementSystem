package com.group.hotelmanagementsystem.service;

import com.group.hotelmanagementsystem.entity.FinancialRecord;

import java.util.List;

public interface FinancialRecordService {
    int deleteByPrimaryKey(Integer financialRecordID);

    int insert(FinancialRecord record);

    int insertSelective(FinancialRecord record);

    FinancialRecord selectByPrimaryKey(Integer financialRecordID);

    int updateByPrimaryKeySelective(FinancialRecord record);

    int updateByPrimaryKey(FinancialRecord record);

    List<FinancialRecord> selectAll();

    int alterTable();
}

