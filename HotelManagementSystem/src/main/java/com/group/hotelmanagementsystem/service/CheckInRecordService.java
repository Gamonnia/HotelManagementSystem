package com.group.hotelmanagementsystem.service;

import com.group.hotelmanagementsystem.entity.CheckInRecord;

import java.util.List;

public interface CheckInRecordService {

    int deleteByPrimaryKey(Integer checkInRecordID);

    int insert(CheckInRecord record);

    int insertSelective(CheckInRecord record);

    CheckInRecord selectByPrimaryKey(Integer checkInRecordID);

    List<CheckInRecord> selectAll();

    int updateByPrimaryKeySelective(CheckInRecord record);

    int updateByPrimaryKey(CheckInRecord record);

    int alterTable();

}
