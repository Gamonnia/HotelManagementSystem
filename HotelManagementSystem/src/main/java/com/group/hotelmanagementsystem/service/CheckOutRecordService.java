package com.group.hotelmanagementsystem.service;

import com.group.hotelmanagementsystem.entity.CheckOutRecord;

import java.util.List;

public interface CheckOutRecordService {
    int deleteByPrimaryKey(Integer checkOutRecordID);

    int insert(CheckOutRecord record);

    int insertSelective(CheckOutRecord record);

    CheckOutRecord selectByPrimaryKey(Integer checkOutRecordID);

    int updateByPrimaryKeySelective(CheckOutRecord record);

    int updateByPrimaryKey(CheckOutRecord record);

    List<CheckOutRecord> selectAll();

    int alterTable();
}
