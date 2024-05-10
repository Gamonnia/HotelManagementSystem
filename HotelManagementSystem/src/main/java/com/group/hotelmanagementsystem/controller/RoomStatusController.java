package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.RoomStatus;
import com.group.hotelmanagementsystem.service.RoomStatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("roomStatus")
public class RoomStatusController {

    @Autowired
    private RoomStatusService roomStatusService;

    @RequestMapping(value = "/deleteByPrimaryKey")
    public boolean deleteByPrimaryKey(@RequestParam("roomStatusID") Integer roomStatusID) {
        try {
            roomStatusService.deleteByPrimaryKey(roomStatusID);
            log.info("Delete roomStatusID: {}, success.", roomStatusID);
            roomStatusService.alterTable();
            log.info("Alter table RoomStatus increment success.");
            return true;
        } catch (Exception e) {
            log.info("Delete RoomStatus or Alter Table failed.");
            log.error(e.getMessage());
            return false;
        }
    }


    @RequestMapping(value = "/insert")
    public RoomStatus insert(@RequestBody RoomStatus record) {
        try {
            if (roomStatusService.selectByRoomStatusName(record.getRoomStatusName()) != null) {
                log.info("Insert - RoomStatus already exists.");
                return null;
            }
            roomStatusService.insert(record);
            log.info("Insert roomStatus success.");
            return roomStatusService.selectByPrimaryKey(record.getRoomStatusID());
        } catch (Exception e) {
            log.info("Insert roomStatus failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/insertSelective")
    public RoomStatus insertSelective(@RequestBody RoomStatus record) {
        try {
            if (roomStatusService.selectByRoomStatusName(record.getRoomStatusName()) != null) {
                log.info("InsertSelective - RoomStatus already exists.");
                return null;
            }
            roomStatusService.insertSelective(record);
            log.info("InsertSelective roomStatus success.");
            return roomStatusService.selectByPrimaryKey(record.getRoomStatusID());
        } catch (Exception e) {
            log.info("InsertSelective roomStatus failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/selectByPrimaryKey")
    public RoomStatus selectByPrimaryKey(@RequestParam("roomStatusID") Integer roomStatusID) {
        try {
            log.info("roomStatusID: {}", roomStatusID);
            return roomStatusService.selectByPrimaryKey(roomStatusID);
        } catch (Exception e) {
            log.info("SelectByPrimaryKey roomStatusID={} failed.", roomStatusID);
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective")
    public RoomStatus updateByPrimaryKeySelective(@RequestBody RoomStatus record) {
        try {
            roomStatusService.updateByPrimaryKeySelective(record);
            log.info("updateSelective roomStatusID={} success.", record.getRoomStatusID());
            return roomStatusService.selectByPrimaryKey(record.getRoomStatusID());
        } catch (Exception e) {
            log.info("updateSelective roomStatusID={} failed.", record.getRoomStatusID());
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/updateByPrimaryKey")
    public RoomStatus updateByPrimaryKey(@RequestBody RoomStatus record) {
        try {
            roomStatusService.updateByPrimaryKey(record);
            log.info("update roomStatusID={} success.", record.getRoomStatusID());
            return roomStatusService.selectByPrimaryKey(record.getRoomStatusID());
        } catch (Exception e) {
            log.info("update roomStatusID={} failed.", record.getRoomStatusID());
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/selectAll")
    public List<RoomStatus> selectAll() {
        try {
            log.info("selectAll RoomStatus table");
            return roomStatusService.selectAll();
        } catch (Exception e) {
            log.info("selectAll RoomStatus table failed.");
            log.error(e.getMessage());
            return null;
        }
    }
}
