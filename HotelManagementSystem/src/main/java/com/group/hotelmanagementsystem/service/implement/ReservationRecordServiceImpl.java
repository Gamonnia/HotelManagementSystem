package com.group.hotelmanagementsystem.service.implement;

import com.group.hotelmanagementsystem.entity.ReservationRecord;
import com.group.hotelmanagementsystem.mapper.ReservationRecordMapper;
import com.group.hotelmanagementsystem.service.ReservationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationRecordServiceImpl implements ReservationRecordService {

    @Autowired
    private ReservationRecordMapper reservationRecordMapper;

    @Override
    public int deleteByPrimaryKey(Integer reservationRecordID) {
        return reservationRecordMapper.deleteByPrimaryKey(reservationRecordID);
    }

    @Override
    public int insert(ReservationRecord record) {
        return reservationRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(ReservationRecord record) {
        return reservationRecordMapper.insertSelective(record);
    }

    @Override
    public ReservationRecord selectByPrimaryKey(Integer reservationRecordID) {
        return reservationRecordMapper.selectByPrimaryKey(reservationRecordID);
    }

    @Override
    public ReservationRecord selectByCustomerName(String customerName) {
        return reservationRecordMapper.selectByCustomerName(customerName);
    }

    @Override
    public int updateByPrimaryKeySelective(ReservationRecord record) {
        return reservationRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ReservationRecord record) {
        return reservationRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ReservationRecord> selectAll() {
        return reservationRecordMapper.selectAll();
    }

    @Override
    public int alterTable() {
        return reservationRecordMapper.alterTable();
    }
}
