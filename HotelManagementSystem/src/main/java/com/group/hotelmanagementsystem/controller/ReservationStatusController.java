package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.ReservationStatus;
import com.group.hotelmanagementsystem.service.ReservationStatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("reservationStatus")
public class ReservationStatusController {
    @Autowired
    private ReservationStatusService reservationStatusService;

    @RequestMapping(value = "/deleteByPrimaryKey")
    public boolean deleteByPrimaryKey(@RequestParam("reservationStatusID") Integer reservationStatusID) {
        try {
            reservationStatusService.deleteByPrimaryKey(reservationStatusID);
            log.info("Delete reservationStatusID: {}, success.", reservationStatusID);
            reservationStatusService.alterTable();
            log.info("Alter table ReservationStatus increment success.");
            return true;
        } catch (Exception e) {
            log.info("Delete ReservationStatus or Alter Table failed.");
            log.error(e.getMessage());
            return false;
        }
    }


    @RequestMapping(value = "/insert")
    public ReservationStatus insert(@RequestBody ReservationStatus record) {
        try {
            if (reservationStatusService.selectByReservationStatusName(record.getReservationStatusName()) != null) {
                log.info("Insert - ReservationStatus already exists.");
                return null;
            }
            reservationStatusService.insert(record);
            log.info("Insert ReservationStatus success.");
            return reservationStatusService.selectByReservationStatusName(record.getReservationStatusName());
        } catch (Exception e) {
            log.info("Insert ReservationStatus failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/insertSelective")
    public ReservationStatus insertSelective(@RequestBody ReservationStatus record) {
        try {
            if (reservationStatusService.selectByReservationStatusName(record.getReservationStatusName()) != null) {
                log.info("InsertSelective - ReservationStatus already exists.");
                return null;
            }
            reservationStatusService.insertSelective(record);
            log.info("InsertSelective ReservationStatus success.");
            return reservationStatusService.selectByPrimaryKey(record.getReservationStatusID());
        } catch (Exception e) {
            log.info("InsertSelective ReservationStatus failed.");
            log.error(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/selectByPrimaryKey")
    public ReservationStatus selectByPrimaryKey(@RequestParam("reservationStatusID") Integer reservationStatusID) {
        try {
            log.info("ReservationStatusID: {}", reservationStatusID);
            return reservationStatusService.selectByPrimaryKey(reservationStatusID);
        } catch (Exception e) {
            log.info("SelectByPrimaryKey ReservationStatusID={} failed.", reservationStatusID);
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective")
    public ReservationStatus updateByPrimaryKeySelective(@RequestBody ReservationStatus record) {
        try {
            reservationStatusService.updateByPrimaryKeySelective(record);
            log.info("updateSelective roomTypeID={} success.", record.getReservationStatusID());
            return reservationStatusService.selectByPrimaryKey(record.getReservationStatusID());
        } catch (Exception e) {
            log.info("updateSelective roomTypeID={} failed.", record.getReservationStatusID());
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/updateByPrimaryKey")
    public ReservationStatus updateByPrimaryKey(@RequestBody ReservationStatus record) {
        try {
            reservationStatusService.updateByPrimaryKey(record);
            log.info("update ReservationStatusID={} success.", record.getReservationStatusID());
            return reservationStatusService.selectByPrimaryKey(record.getReservationStatusID());
        } catch (Exception e) {
            log.info("update ReservationStatusID={} failed.", record.getReservationStatusID());
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/selectAll")
    public List<ReservationStatus> selectAll() {
        try {
            log.info("selectAll ReservationStatus table");
            return reservationStatusService.selectAll();
        } catch (Exception e) {
            log.info("selectAll ReservationStatus table failed.");
            log.error(e.getMessage());
            return null;
        }
    }
}
