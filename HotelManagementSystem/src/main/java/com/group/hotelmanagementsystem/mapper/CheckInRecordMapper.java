package com.group.hotelmanagementsystem.mapper;

import com.group.hotelmanagementsystem.entity.CheckInRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CheckInRecordMapper {

    int deleteByPrimaryKey(Integer checkInRecordID);

    int insert(CheckInRecord record);

    int insertSelective(CheckInRecord record);

    CheckInRecord selectByPrimaryKey(Integer checkInRecordID);

    CheckInRecord selectByCustomerIsCheckOut(Integer customerID);

    int updateByPrimaryKeySelective(CheckInRecord record);

    int updateByPrimaryKey(CheckInRecord record);

    List<CheckInRecord> selectAll();

    int alterTable();
}