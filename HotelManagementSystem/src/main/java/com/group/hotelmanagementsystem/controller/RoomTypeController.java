package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.RoomType;
import com.group.hotelmanagementsystem.service.RoomTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/roomType")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;

    @RequestMapping(value = "/deleteByPrimaryKey")
    public boolean deleteByPrimaryKey(@RequestParam("roomTypeID") Integer roomTypeID) {
        try {
            roomTypeService.deleteByPrimaryKey(roomTypeID);
            log.info("Delete roomTypeID: {}, success.", roomTypeID);
            roomTypeService.alterTable();
            log.info("Alter table RoomType increment success.");
            return true;
        } catch (Exception e) {
            log.info("Delete RoomType or Alter Table failed.");
            log.error(e.getMessage());
            return false;
        }
    }


    @RequestMapping(value = "/insert")
    public RoomType insert(@RequestBody RoomType record) {
        try {
            if (roomTypeService.selectByRoomTypeName(record.getRoomTypeName()) != null) {
                log.info("Insert - RoomType already exists.");
                return null;
            }
            roomTypeService.insert(record);
            log.info("Insert roomType success.");
            return roomTypeService.selectByPrimaryKey(record.getRoomTypeID());
        } catch (Exception e) {
            log.info("Insert roomType failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/insertSelective")
    public RoomType insertSelective(@RequestBody RoomType record) {
        try {
            if (roomTypeService.selectByRoomTypeName(record.getRoomTypeName()) != null) {
                log.info("InsertSelective - RoomType already exists.");
                return null;
            }
            roomTypeService.insertSelective(record);
            log.info("InsertSelective roomType success.");
            return roomTypeService.selectByPrimaryKey(record.getRoomTypeID());
        } catch (Exception e) {
            log.info("InsertSelective roomType failed.");
            log.error(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/selectByPrimaryKey")
    public RoomType selectByPrimaryKey(@RequestParam("roomTypeID") Integer roomTypeID) {
        try {
            log.info("roomTypeID: {}", roomTypeID);
            return roomTypeService.selectByPrimaryKey(roomTypeID);
        } catch (Exception e) {
            log.info("SelectByPrimaryKey roomTypeID={} failed.", roomTypeID);
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective")
    public RoomType updateByPrimaryKeySelective(@RequestBody RoomType record) {
        try {
            roomTypeService.updateByPrimaryKeySelective(record);
            log.info("updateSelective roomTypeID={} success.", record.getRoomTypeID());
            return roomTypeService.selectByPrimaryKey(record.getRoomTypeID());
        } catch (Exception e) {
            log.info("updateSelective roomTypeID={} failed.", record.getRoomTypeID());
            log.error(e.getMessage());
            return roomTypeService.selectByPrimaryKey(record.getRoomTypeID());
        }
    }


    @RequestMapping(value = "/updateByPrimaryKey")
    public RoomType updateByPrimaryKey(@RequestBody RoomType record) {
        try {
            roomTypeService.updateByPrimaryKey(record);
            log.info("update roomTypeID={} success.", record.getRoomTypeID());
            return roomTypeService.selectByPrimaryKey(record.getRoomTypeID());
        } catch (Exception e) {
            log.info("update roomTypeID={} failed.", record.getRoomTypeID());
            log.error(e.getMessage());
            return roomTypeService.selectByPrimaryKey(record.getRoomTypeID());
        }
    }


    @RequestMapping(value = "/selectAll")
    public List<RoomType> selectAll() {
        try {
            log.info("selectAll RoomType table");
            return roomTypeService.selectAll();
        } catch (Exception e) {
            log.info("selectAll RoomType table failed.");
            log.error(e.getMessage());
            return null;
        }
    }
}
