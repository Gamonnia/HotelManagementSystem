package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.ReservationRecord;
import com.group.hotelmanagementsystem.service.ReservationRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("reservationRecord")
public class ReservationRecordController {

    @Autowired
    private ReservationRecordService reservationRecordService;


    @RequestMapping(value = "/deleteByPrimaryKey")
    public String deleteByPrimaryKey(@RequestParam("reservationID") Integer reservationRecordID) {
        try {
            reservationRecordService.deleteByPrimaryKey(reservationRecordID);
            log.info("Delete reservationID: {}, success.", reservationRecordID);
            reservationRecordService.alterTable();
            log.info("Alter table ReservationRecord increment success.");
            return "Delete reservationID: " + reservationRecordID + " success.";
        } catch (Exception e) {
            log.info("Delete ReservationRecord or Alter Table failed.");
            log.error(e.getMessage());
            return "Delete reservationID: " + reservationRecordID + " failed.";
        }
    }


    @RequestMapping(value = "/insert")
    public ReservationRecord insert(@RequestBody ReservationRecord record) {
        try {
            reservationRecordService.insert(record);
            log.info("Insert reservationRecord success.");
            return reservationRecordService.selectByPrimaryKey(record.getReservationRecordID());
        } catch (Exception e) {
            log.info("Insert ReservationRecord failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/insertSelective")
    public ReservationRecord insertSelective(@RequestBody ReservationRecord record) {
        try {
            reservationRecordService.insertSelective(record);
            log.info("InsertSelective reservationRecord success.");
            return reservationRecordService.selectByPrimaryKey(record.getReservationRecordID());
        } catch (Exception e) {
            log.info("InsertSelective ReservationRecord failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/selectByPrimaryKey")
    public ReservationRecord selectByPrimaryKey(@RequestParam("reservationRecordID") Integer reservationRecordID) {
        try {
            log.info("reservationRecordID: {}", reservationRecordID);
            return reservationRecordService.selectByPrimaryKey(reservationRecordID);
        } catch (Exception e) {
            log.info("SelectByPrimaryKey reservationRecordID={} failed.", reservationRecordID);
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective")
    public ReservationRecord updateByPrimaryKeySelective(@RequestBody ReservationRecord record) {
        try {
            reservationRecordService.updateByPrimaryKeySelective(record);
            log.info("updateSelective reservationRecordID={} success.", record.getReservationRecordID());
            return reservationRecordService.selectByPrimaryKey(record.getReservationRecordID());
        } catch (Exception e) {
            log.info("updateSelective reservationRecordID={} failed.", record.getReservationRecordID());
            log.error(e.getMessage());
            return reservationRecordService.selectByPrimaryKey(record.getReservationRecordID());
        }
    }


    @RequestMapping(value = "/updateByPrimaryKey")
    public ReservationRecord updateByPrimaryKey(@RequestBody ReservationRecord record) {
        try {
            reservationRecordService.updateByPrimaryKey(record);
            log.info("update reservationRecordID={} success.", record.getReservationRecordID());
            return reservationRecordService.selectByPrimaryKey(record.getReservationRecordID());
        } catch (Exception e) {
            log.info("update reservationRecordID={} failed.", record.getReservationRecordID());
            log.error(e.getMessage());
            return reservationRecordService.selectByPrimaryKey(record.getReservationRecordID());
        }
    }


    @RequestMapping(value = "/selectAll")
    public List<ReservationRecord> selectAll() {
        try {
            log.info("selectAll ReservationRecord table");
            return reservationRecordService.selectAll();
        } catch (Exception e) {
            log.info("selectAll ReservationRecord table failed.");
            log.error(e.getMessage());
            return null;
        }
    }
}
