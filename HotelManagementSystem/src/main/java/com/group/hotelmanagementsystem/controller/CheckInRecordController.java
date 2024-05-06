package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.CheckInRecord;
import com.group.hotelmanagementsystem.entity.Customer;
import com.group.hotelmanagementsystem.entity.ReservationRecord;
import com.group.hotelmanagementsystem.entity.Room;
import com.group.hotelmanagementsystem.service.CheckInRecordService;
import com.group.hotelmanagementsystem.service.CustomerService;
import com.group.hotelmanagementsystem.service.ReservationRecordService;
import com.group.hotelmanagementsystem.service.RoomService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("checkInRecord")
public class CheckInRecordController {

    @Autowired
    private CheckInRecordService checkInRecordService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ReservationRecordService reservationRecordService;

    @RequestMapping(value = "/deleteByPrimaryKey")
    public boolean deleteByPrimaryKey(@RequestParam("checkInRecordID") Integer checkInRecordID) {
        try {
            // update room status
            CheckInRecord checkInRecord = checkInRecordService.selectByPrimaryKey(checkInRecordID);
            Room room = new Room();
            room.setRoomID(checkInRecord.getRoomID());
            room.setRoomStatusID(1);
            roomService.updateByPrimaryKeySelective(room);
            log.info("Delete - room update success");
            // delete
            checkInRecordService.deleteByPrimaryKey(checkInRecordID);
            log.info("Delete checkInRecordID: {}, success.", checkInRecordID);
            checkInRecordService.alterTable();
            log.info("Alter table CheckInRecord increment success.");
            return true;
        } catch (Exception e) {
            log.info("Delete CheckInRecord or Alter Table failed.");
            log.error(e.getMessage());
            return false;
        }
    }


    @RequestMapping(value = "/insert")
    public CheckInRecord insert(@RequestBody ParamOfCheckInRecord param) {
        try {
            // verify Customer data
            Customer customer = customerService.selectCustomer(param.getCustomer());
            if (customer == null) {
                customerService.insert(param.getCustomer());
            } else param.setCustomer(customer);
            // update param
            if (updateRoom(param)) {
                log.info("Insert - Room update success");
            } else log.info("Insert - Room update failed");
            // insert check in record
            param.getCheckInRecord().setCustomerID(param.getCustomer().getCustomerID());
            checkInRecordService.insert(param.getCheckInRecord());
            log.info("Insert success");
            return checkInRecordService.selectByPrimaryKey(param.getCheckInRecord().getCheckInRecordID());
        } catch (Exception e) {
            log.info("Insert failed");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/insertSelective")
    public CheckInRecord insertSelective(@RequestBody ParamOfCheckInRecord param) {
        try {
            // verify Customer data
            Customer customer = customerService.selectCustomer(param.getCustomer());
            if (customer == null) {
                customerService.insertSelective(param.getCustomer());
            } else param.setCustomer(customer);
            // update param
            if (updateRoom(param)) {
                log.info("InsertSelective - Room update success");
            } else log.info("InsertSelective - Room update failed");
            // insert check in record
            param.getCheckInRecord().setCustomerID(param.getCustomer().getCustomerID());
            checkInRecordService.insertSelective(param.getCheckInRecord());
            log.info("InsertSelective success");
            return checkInRecordService.selectByPrimaryKey(param.getCheckInRecord().getCheckInRecordID());
        } catch (Exception e) {
            log.info("InsertSelective failed");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "selectByPrimaryKey")
    public CheckInRecord selectByPrimaryKey(@RequestParam("checkInRecordID") Integer checkInRecordID) {
        try {
            log.info("checkInRecordID: {}", checkInRecordID);
            return checkInRecordService.selectByPrimaryKey(checkInRecordID);
        } catch (Exception e) {
            log.info("SelectByPrimaryKey checkInRecordID={} failed.", checkInRecordID);
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/updateByPrimaryKey")
    public CheckInRecord updateByPrimaryKey(@RequestBody ParamOfCheckInRecord param) {
        try{
            checkInRecordService.updateByPrimaryKey(param.getCheckInRecord());
            log.info("update checkInRecordID={} success.", param.getCheckInRecord().getCheckInRecordID());
            customerService.updateByPrimaryKey(param.getCustomer());
            log.info("update customerID={} success.", param.getCustomer().getCustomerID());
            return checkInRecordService.selectByPrimaryKey(param.getCheckInRecord().getCheckInRecordID());
        }catch (Exception e){
            log.info("update checkInRecordID={} failed.", param.getCheckInRecord().getCheckInRecordID());
            log.error(e.getMessage());
            return checkInRecordService.selectByPrimaryKey(param.getCheckInRecord().getCheckInRecordID());
        }
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective")
    public CheckInRecord updateByPrimaryKeySelective(@RequestBody ParamOfCheckInRecord param) {
        try {
            checkInRecordService.updateByPrimaryKeySelective(param.getCheckInRecord());
            log.info("updateSelective checkInRecordID={} success.", param.getCheckInRecord().getCheckInRecordID());
            customerService.updateByPrimaryKey(param.getCustomer());
            log.info("updateSelective customerID={} success.", param.getCustomer().getCustomerID());
            return checkInRecordService.selectByPrimaryKey(param.getCheckInRecord().getCheckInRecordID());
        } catch (Exception e) {
            log.info("updateSelective checkInRecordID={} failed.", param.getCheckInRecord().getCheckInRecordID());
            log.error(e.getMessage());
            return checkInRecordService.selectByPrimaryKey(param.getCheckInRecord().getCheckInRecordID());
        }
    }

    @RequestMapping(value = "/selectAll")
    public List<CheckInRecord> selectAll() {
        try {
            log.info("selectAll CheckInRecord table.");
            return checkInRecordService.selectAll();
        } catch (Exception e) {
            log.info("selectAll CheckInRecord table failed.");
            log.error(e.getMessage());
            return null;
        }
    }

    @Setter
    @Getter
    public static class ParamOfCheckInRecord {
        private CheckInRecord checkInRecord;
        private Customer customer;
    }

    public static <T> T getRandomElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }


    /**
     * update room status
     * @param param Param
     * @return true or false
     */
    public boolean updateRoom(ParamOfCheckInRecord param) {
        try {
            // verify Reservation Record
            ReservationRecord reservationRecord = reservationRecordService.selectByCustomerName(param.getCustomer().getCustomerName());
            Room room = roomService.selectByPrimaryKey(param.getCheckInRecord().getRoomID());

            // check the room status
            if (room.getRoomStatusID() == 3) {
                return false;
            }
            if (reservationRecord != null) {
                // update room status
                Room reservedRoom = new Room();
                reservedRoom.setRoomStatusID(4);
                List<Room> roomList;
                if (Objects.equals(reservationRecord.getRoomTypeID(), room.getRoomTypeID())) {
                    // verify room status
                    if (room.getRoomStatusID() != 4) {
                        // update reserved room
                        reservedRoom.setRoomTypeID(room.getRoomTypeID());
                        roomList = roomService.selectByRoomStatusIDAndRoomTypeID(reservedRoom);
                        reservedRoom = getRandomElement(roomList);
                        reservedRoom.setRoomStatusID(1);
                        roomService.updateByPrimaryKeySelective(reservedRoom);
                    }
                } else {
                    // update reserved room
                    reservedRoom.setRoomTypeID(reservationRecord.getRoomTypeID());
                    roomList = roomService.selectByRoomStatusIDAndRoomTypeID(reservedRoom);
                    reservedRoom = getRandomElement(roomList);
                    reservedRoom.setRoomStatusID(1);
                    roomService.updateByPrimaryKeySelective(reservedRoom);
                }
            }
            // update check in room
            room.setRoomStatusID(3);
            roomService.updateByPrimaryKeySelective(room);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }
}
