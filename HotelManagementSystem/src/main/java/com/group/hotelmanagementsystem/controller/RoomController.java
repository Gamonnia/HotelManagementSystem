package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.Room;
import com.group.hotelmanagementsystem.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/deleteByPrimaryKey")
    public Boolean deleteByPrimaryKey(@RequestParam("roomID") Integer roomID) {
        try {
           roomService.deleteByPrimaryKey(roomID);
            log.info("Delete roomID: {}, success.", roomID);
            roomService.alterTable();
            log.info("Alter table Room increment success.");
            return true;
        } catch (Exception e) {
            log.info("Delete Room or Alter Table failed.");
            log.error(e.getMessage());
            return false;
        }
    }


    @RequestMapping(value = "/insert")
    public Room insert(@RequestBody Room record) {
        try {
            if (roomService.selectByPrimaryKey(record.getRoomID()) != null) {
                log.info("Insert - Room already exist.");
                return null;
            }
            roomService.insert(record);
            log.info("Insert room success.");
            return roomService.selectByPrimaryKey(record.getRoomID());
        } catch (Exception e) {
            log.info("Insert room failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/insertSelective")
    public Room insertSelective(@RequestBody Room record) {
        try {
            if (roomService.selectByPrimaryKey(record.getRoomID()) != null) {
                log.info("InsertSelective - Room already exist.");
                return null;
            }
            roomService.insertSelective(record);
            log.info("InsertSelective room success.");
            return roomService.selectByPrimaryKey(record.getRoomID());
        } catch (Exception e) {
            log.info("InsertSelective room failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/selectByPrimaryKey")
    public Room selectByPrimaryKey(@RequestParam("roomID") Integer roomID) {
        try {
            log.info("roomID: {}", roomID);
            return roomService.selectByPrimaryKey(roomID);
        } catch (Exception e) {
            log.info("SelectByPrimaryKey roomID={} failed.", roomID);
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective")
    public Room updateByPrimaryKeySelective(@RequestBody Room record) {
        try {
            roomService.updateByPrimaryKeySelective(record);
            log.info("updateSelective roomID={} success.", record.getRoomID());
            return roomService.selectByPrimaryKey(record.getRoomID());
        } catch (Exception e) {
            log.info("updateSelective roomID={} failed.", record.getRoomID());
            log.error(e.getMessage());
            return roomService.selectByPrimaryKey(record.getRoomID());
        }
    }


    @RequestMapping(value = "/updateByPrimaryKey")
    public Room updateByPrimaryKey(@RequestBody Room record) {
        try {
            roomService.updateByPrimaryKey(record);
            log.info("update roomID={} success.", record.getRoomID());
            return roomService.selectByPrimaryKey(record.getRoomID());
        } catch (Exception e) {
            log.info("update roomID={} failed.", record.getRoomID());
            log.error(e.getMessage());
            return roomService.selectByPrimaryKey(record.getRoomID());
        }
    }


    @RequestMapping(value = "/selectAll")
    public List<Room> selectAll() {
        try {
            log.info("selectAll Room table");
            return roomService.selectAll();
        } catch (Exception e) {
            log.info("selectAll Room table failed.");
            log.error(e.getMessage());
            return null;
        }
    }
}
