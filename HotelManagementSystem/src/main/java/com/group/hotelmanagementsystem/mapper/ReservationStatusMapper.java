package com.group.hotelmanagementsystem.mapper;

import com.group.hotelmanagementsystem.entity.ReservationStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationStatusMapper {
    int deleteByPrimaryKey(Integer reservationId);

    int insert(ReservationStatus record);

    int insertSelective(ReservationStatus record);

    ReservationStatus selectByPrimaryKey(Integer reservationId);

    ReservationStatus selectByReservationStatusName(String reservationStatusName);

    int updateByPrimaryKeySelective(ReservationStatus record);

    int updateByPrimaryKey(ReservationStatus record);

    List<ReservationStatus> selectAll();

    int alterTable();
}
