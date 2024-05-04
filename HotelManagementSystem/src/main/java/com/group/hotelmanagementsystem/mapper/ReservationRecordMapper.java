package com.group.hotelmanagementsystem.mapper;

import com.group.hotelmanagementsystem.entity.ReservationRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationRecordMapper {
    int deleteByPrimaryKey(Integer reservationRecordID);

    int insert(ReservationRecord record);

    int insertSelective(ReservationRecord record);

    ReservationRecord selectByPrimaryKey(Integer reservationRecordID);

    ReservationRecord selectByCustomerName(String customerName);

    int updateByPrimaryKeySelective(ReservationRecord record);

    int updateByPrimaryKey(ReservationRecord record);

    List<ReservationRecord> selectAll();

    int alterTable();
}