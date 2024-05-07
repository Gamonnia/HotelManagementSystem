package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.CheckInRecord;
import com.group.hotelmanagementsystem.entity.CheckOutRecord;
import com.group.hotelmanagementsystem.entity.Room;
import com.group.hotelmanagementsystem.service.CheckOutRecordService;
import com.group.hotelmanagementsystem.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@Slf4j
@RequestMapping("checkOutRecord")
public class CheckOutRecordController {

    @Autowired
    private CheckOutRecordService checkOutRecordService;

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/deleteByPrimaryKey")
    public boolean deleteByPrimaryKey(@RequestParam("CheckOutRecordID") Integer checkOutRecordID) {
        try {
            // update room status
            CheckOutRecord checkOutRecord = checkOutRecordService.selectByPrimaryKey(checkOutRecordID);
            Room room = new Room();
            room.setRoomID(checkOutRecord.getRoomID());
            room.setRoomStatusID(1);
            roomService.updateByPrimaryKeySelective(room);
            log.info("Delete - room update success");
            // Delete
            checkOutRecordService.deleteByPrimaryKey(checkOutRecordID);
            log.info("Delete checkOutRecordID: {}, success.", checkOutRecordID);
            checkOutRecordService.alterTable();
            log.info("Alter table CheckOutRecord increment success.");
            return true;
        } catch (Exception e) {
            log.info("Delete CheckOutRecord or Alter Table failed.");
            log.error(e.getMessage());
            return false;
        }
    }


    @RequestMapping(value = "/insert")
    public CheckOutRecord insert(@RequestBody CheckOutRecord record) {
        try {
            checkOutRecordService.insert(record);
            log.info("Insert checkOutRecord success.");
            // update room status
            Room room = new Room();
            room.setRoomID(record.getRoomID());
            room.setRoomStatusID(1);
            roomService.updateByPrimaryKeySelective(room);
            log.info("Insert - Room update success");
            return checkOutRecordService.selectByPrimaryKey(record.getCheckOutRecordID());
        } catch (Exception e) {
            log.info("Insert checkOutRecord failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/insertSelective")
    public CheckOutRecord insertSelective(@RequestBody CheckOutRecord record) {
        try {
            checkOutRecordService.insertSelective(record);
            log.info("InsertSelective checkOutRecord success.");
            // update room status
            Room room = new Room();
            room.setRoomID(record.getRoomID());
            room.setRoomStatusID(1);
            roomService.updateByPrimaryKeySelective(room);
            log.info("InsertSelective - room update success");
            return checkOutRecordService.selectByPrimaryKey(record.getCheckOutRecordID());
        } catch (Exception e) {
            log.info("InsertSelective checkOutRecord failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/selectByPrimaryKey")
    public CheckOutRecord selectByPrimaryKey(@RequestParam("checkOutRecordID") Integer checkOutRecordID) {
        try {
            log.info("checkOutRecordID: {}", checkOutRecordID);
            return checkOutRecordService.selectByPrimaryKey(checkOutRecordID);
        } catch (Exception e) {
            log.info("SelectByPrimaryKey checkOutRecordID={} failed.", checkOutRecordID);
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/updateByPrimaryKey")
    public CheckOutRecord updateByPrimaryKey(@RequestBody CheckOutRecord record) {
        try {
            checkOutRecordService.updateByPrimaryKey(record);
            log.info("update checkOutRecordID={} success.", record.getCheckOutRecordID());
            return checkOutRecordService.selectByPrimaryKey(record.getCheckOutRecordID());
        } catch (Exception e) {
            log.info("update checkOutRecordID={} failed.", record.getCheckOutRecordID());
            log.error(e.getMessage());
            return checkOutRecordService.selectByPrimaryKey(record.getCheckOutRecordID());
        }
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective")
    public CheckOutRecord updateByPrimaryKeySelective(@RequestBody CheckOutRecord record) {
        try {
            checkOutRecordService.updateByPrimaryKeySelective(record);
            log.info("updateSelective checkOutRecordID={} success.", record.getCheckOutRecordID());
            return checkOutRecordService.selectByPrimaryKey(record.getCheckOutRecordID());
        } catch (Exception e) {
            log.info("updateSelective checkOutRecordID={} failed.", record.getCheckOutRecordID());
            log.error(e.getMessage());
            return checkOutRecordService.selectByPrimaryKey(record.getCheckOutRecordID());
        }
    }


    @RequestMapping(value = "/selectAll")
    public List<CheckOutRecord> selectAll() {
        try {
            log.info("selectAll CheckOutRecord table");
            return checkOutRecordService.selectAll();
        } catch (Exception e) {
            log.info("selectAll CheckOutRecord table failed.");
            log.error(e.getMessage());
            return null;
        }
    }
}
