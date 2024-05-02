package com.group.hotelmanagementsystem.service;

import com.group.hotelmanagementsystem.entity.ReservationRecord;

import java.util.List;

public interface ReservationRecordService {
    int deleteByPrimaryKey(Integer reservationRecordID);

    int insert(ReservationRecord record);

    int insertSelective(ReservationRecord record);

    ReservationRecord selectByPrimaryKey(Integer reservationRecordID);

    int updateByPrimaryKeySelective(ReservationRecord record);

    int updateByPrimaryKey(ReservationRecord record);

    List<ReservationRecord> selectAll();

    int alterTable();
}
