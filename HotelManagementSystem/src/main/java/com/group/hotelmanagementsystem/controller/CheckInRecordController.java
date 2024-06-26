package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.*;
import com.group.hotelmanagementsystem.service.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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
    private CheckOutRecordService checkOutRecordService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ReservationRecordService reservationRecordService;

    @Autowired
    private FinancialRecordService financialRecordService;

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
            param.getCheckInRecord().setCustomerID(param.getCustomer().getCustomerID());

            // verify check out or not
            if (checkInRecordService.selectByCustomerIsCheckOut(param.getCheckInRecord().getCustomerID()) != null) {
                log.info("Insert - CustomerID={} checkInRecord already exist", param.getCheckInRecord().getCustomerID());
                return null;
            }

            // update param
            if (updateRoom(param)) {
                log.info("Insert - Room update success");
            } else {
                log.info("Insert - Room update failed");
                return null;
            }

            // insert check in record
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
            param.getCheckInRecord().setCustomerID(param.getCustomer().getCustomerID());
            // update param
            if (updateRoom(param)) {
                log.info("InsertSelective - Room update success");
            } else {
                log.info("InsertSelective - Room update failed");
                return null;
            }

            // verify check out or not
            if (checkInRecordService.selectByCustomerIsCheckOut(param.getCheckInRecord().getCustomerID()) != null) {
                log.info("InsertSelective - Room checkInRecord already exist");
                return null;
            }
            // insert check in record
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
            return null;
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
            return null;
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


    @RequestMapping(value = "/checkOut")
    public boolean checkOut(@RequestParam("checkInRecordID") Integer checkInRecordID) {
        try {
            log.info("Get the checkInRecordID: {}", checkInRecordID);
            CheckInRecord checkInRecord = checkInRecordService.selectByPrimaryKey(checkInRecordID);
            checkInRecord.setCheckOutOrNot(true);

            log.info("Get the roomID: {}", checkInRecord.getRoomID());
            Room room = roomService.selectByPrimaryKey(checkInRecord.getRoomID());
            room.setRoomStatusID(1);

            log.info("Check Out checkInRecordID={}, ...", checkInRecordID);
            checkInRecordService.updateByPrimaryKeySelective(checkInRecord);
            roomService.updateByPrimaryKeySelective(room);
            log.info("Check Out checkInRecordID={} success.", checkInRecordID);

            // insert check out record
            try {
                // create a new checkOut record
                CheckOutRecord checkOutRecord = new CheckOutRecord();
                checkOutRecord.setCustomerID(checkInRecord.getCustomer().getCustomerID());
                checkOutRecord.setRoomID(room.getRoomID());
                checkOutRecord.setCheckInTime(checkInRecord.getCheckInTime());
                Timestamp currentTime = new Timestamp(System.currentTimeMillis()); // get current time
                checkOutRecord.setCheckOutTime(currentTime);
                checkOutRecord.setStaffID(checkInRecord.getStaffID());
                checkOutRecord.setRecordTime(currentTime);

                // insert a new checkOut record
                checkOutRecordService.insert(checkOutRecord);
                log.info("Insert checkOutRecord success.");

                // insert a new financial record
                log.info("Insert a new Financial record....");
                FinancialRecord financialRecord = new FinancialRecord();
                RoomType roomType = room.getRoomType();
                financialRecord.setAmount(roomType.getRoomPrice());
                financialRecord.setDate(currentTime);
                financialRecord.setIncomeOrExpense("Room Revenue");
                financialRecordService.insert(financialRecord);
                log.info("Insert - Financial record success");
            } catch (Exception e) {
                log.info("Insert checkOutRecord failed.");
                log.error(e.getMessage());
                return false;
            }
            return true;
        } catch (Exception e) {
            log.info("Check Out checkInRecordID={} failed.", checkInRecordID);
            log.error(e.getMessage());
            return false;
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
            log.info("Search the Reservation and Room ......");
            // get Reservation Record and room
            ReservationRecord reservationRecord = reservationRecordService.selectByCustomerName(param.getCustomer().getCustomerName());
            Room room = roomService.selectByPrimaryKey(param.getCheckInRecord().getRoomID());

            // check the room status
            log.info("Verify the Room......");
            if (room.getRoomStatusID() == 3) {
                log.info("This room is already in use.");
                return false;
            }

            // check the record
            if (reservationRecord != null) {
                // update room status
                Room reservedRoom = new Room();
                reservedRoom.setRoomStatusID(4);
                List<Room> roomList;

                log.info("check the room type......");
                if (Objects.equals(reservationRecord.getRoomTypeID(), room.getRoomTypeID())) {
                    log.info("The reserved room type is the same as the current room type.");
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
                    log.info("The reserved room type is the different from the current room type.");
                    // update reserved room
                    reservedRoom.setRoomTypeID(reservationRecord.getRoomTypeID());
                    roomList = roomService.selectByRoomStatusIDAndRoomTypeID(reservedRoom);
                    reservedRoom = getRandomElement(roomList);
                    reservedRoom.setRoomStatusID(1);
                    roomService.updateByPrimaryKeySelective(reservedRoom);
                }
                log.info("update the reservation status......");
                reservationRecord.setReservationStatusID(2);
                reservationRecordService.updateByPrimaryKeySelective(reservationRecord);
            } else {
                log.info("Reservation record is null.");
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
