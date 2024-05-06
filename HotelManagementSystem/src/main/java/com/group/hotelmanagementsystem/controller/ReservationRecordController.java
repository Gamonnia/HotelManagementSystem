package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.ReservationRecord;
import com.group.hotelmanagementsystem.entity.Room;
import com.group.hotelmanagementsystem.service.ReservationRecordService;
import com.group.hotelmanagementsystem.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("reservationRecord")
public class ReservationRecordController {

    @Autowired
    private ReservationRecordService reservationRecordService;

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/deleteByPrimaryKey")
    public boolean deleteByPrimaryKey(@RequestParam("reservationID") Integer reservationRecordID) {
        try {
            // update room status
            ReservationRecord reservationRecord = reservationRecordService.selectByPrimaryKey(reservationRecordID);
            Room reservedRoom = new Room();
            reservedRoom.setRoomStatusID(4);
            reservedRoom.setRoomTypeID(reservationRecord.getRoomTypeID());
            List<Room> roomList = roomService.selectByRoomStatusIDAndRoomTypeID(reservedRoom);
            Room room = getRandomElement(roomList);
            if (room != null) {
                room.setRoomStatusID(1);
                roomService.updateByPrimaryKeySelective(room);
                log.info("Delete - room update success");
            } else log.info("Delete - Don't have any available room.);");
            // delete
            reservationRecordService.deleteByPrimaryKey(reservationRecordID);
            log.info("Delete reservationID: {}, success.", reservationRecordID);
            reservationRecordService.alterTable();
            log.info("Alter table ReservationRecord increment success.");
            return true;
        } catch (Exception e) {
            log.info("Delete ReservationRecord or Alter Table failed.");
            log.error(e.getMessage());
            return false;
        }
    }


    @RequestMapping(value = "/insert")
    public ReservationRecord insert(@RequestBody ReservationRecord record) {
        try {
            // assign room
            List<Room> roomList = roomService.selectByRoomByTypeID(record.getRoomTypeID());
            Room room = getRandomElement(roomList);
            if (room != null) {
                reservationRecordService.insert(record);
                log.info("Insert reservationRecord success.");
                // update room status
                room.setRoomStatusID(4);
                roomService.updateByPrimaryKeySelective(room);
                log.info("Insert - room update success");
                return reservationRecordService.selectByPrimaryKey(record.getReservationRecordID());
            } else {
                log.info("Don't have any available room.");
                return null;
            }
        } catch (Exception e) {
            log.info("Insert ReservationRecord failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/insertSelective")
    public ReservationRecord insertSelective(@RequestBody ReservationRecord record) {
        try {
            // assign room
            List<Room> roomList = roomService.selectByRoomByTypeID(record.getRoomTypeID());
            Room room = getRandomElement(roomList);
            if (room != null) {
                reservationRecordService.insertSelective(record);
                log.info("InsertSelective reservationRecord success.");
                // update room status
                room.setRoomStatusID(4);
                roomService.updateByPrimaryKeySelective(room);
                log.info("InsertSelective - room update success");
                return reservationRecordService.selectByPrimaryKey(record.getReservationRecordID());
            } else {
                log.info("InsertSelective - Don't have any available room.");
                return null;
            }
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


    public static <T> T getRandomElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
