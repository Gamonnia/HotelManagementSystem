package com.group.hotelmanagementsystem.service.implement;

import com.group.hotelmanagementsystem.entity.ReservationStatus;
import com.group.hotelmanagementsystem.mapper.ReservationStatusMapper;
import com.group.hotelmanagementsystem.service.ReservationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationStatusServiceImpl implements ReservationStatusService {

    @Autowired
    private ReservationStatusMapper reservationStatusMapper;

    @Override
    public int deleteByPrimaryKey(Integer reservationId) {
        return reservationStatusMapper.deleteByPrimaryKey(reservationId);
    }

    @Override
    public int insert(ReservationStatus record) {
        return reservationStatusMapper.insert(record);
    }

    @Override
    public int insertSelective(ReservationStatus record) {
        return reservationStatusMapper.insertSelective(record);
    }

    @Override
    public ReservationStatus selectByPrimaryKey(Integer reservationId) {
        return reservationStatusMapper.selectByPrimaryKey(reservationId);
    }

    @Override
    public ReservationStatus selectByReservationStatusName(String reservationStatusName) {
        return reservationStatusMapper.selectByReservationStatusName(reservationStatusName);
    }

    @Override
    public int updateByPrimaryKeySelective(ReservationStatus record) {
        return reservationStatusMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ReservationStatus record) {
        return reservationStatusMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ReservationStatus> selectAll() {
        return reservationStatusMapper.selectAll();
    }

    @Override
    public int alterTable() {
        return reservationStatusMapper.alterTable();
    }
}
