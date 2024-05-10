package com.group.hotelmanagementsystem.service;

import com.group.hotelmanagementsystem.entity.ReservationStatus;

import java.util.List;

public interface ReservationStatusService {
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
