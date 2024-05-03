package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.CheckInRecord;
import com.group.hotelmanagementsystem.entity.Customer;
import com.group.hotelmanagementsystem.entity.Room;
import com.group.hotelmanagementsystem.service.CheckInRecordService;
import com.group.hotelmanagementsystem.service.CustomerService;
import com.group.hotelmanagementsystem.service.RoomService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/deleteByPrimaryKey")
    public String deleteByPrimaryKey(@RequestParam("checkInRecordID") Integer checkInRecordID) {
        try {
            checkInRecordService.deleteByPrimaryKey(checkInRecordID);
            log.info("Delete checkInRecordID: {}, success.", checkInRecordID);
            checkInRecordService.alterTable();
            log.info("Alter table CheckInRecord increment success.");
            // update room status
            Room room = new Room();
            room.setRoomStatusID(1);
            roomService.updateByPrimaryKeySelective(room);
            log.info("Delete - room update success");
            return "Delete checkInRecordID: " + checkInRecordID + " success.";
        } catch (Exception e) {
            log.info("Delete CheckInRecord or Alter Table failed.");
            log.error(e.getMessage());
            return "Delete checkInRecordID: " + checkInRecordID + " failed.";
        }
    }


    @RequestMapping(value = "/insert")
    public CheckInRecord insert(@RequestBody ParamOfCheckInRecord param) {
        try {
            Customer customer = customerService.selectCustomer(param.getCustomer());
            if (customer == null) {
                customerService.insert(param.getCustomer());
            } else param.setCustomer(customer);

            param.getCheckInRecord().setCustomerID(param.getCustomer().getCustomerID());
            checkInRecordService.insert(param.getCheckInRecord());
            log.info("Insert checkInRecord success");
            // update room status
            Room room = new Room();
            room.setRoomStatusID(3);
            roomService.updateByPrimaryKeySelective(room);
            log.info("Insert - Room update success");
            return checkInRecordService.selectByPrimaryKey(param.getCheckInRecord().getCheckInRecordID());
        } catch (Exception e) {
            log.info("Insert checkInRecord failed");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/insertSelective")
    public CheckInRecord insertSelective(@RequestBody ParamOfCheckInRecord param) {
        try {
            Customer customer = customerService.selectCustomer(param.getCustomer());
            if (customer == null) {
                customerService.insertSelective(param.getCustomer());
            } else param.setCustomer(customer);

            param.getCheckInRecord().setCustomerID(param.getCustomer().getCustomerID());
            checkInRecordService.insertSelective(param.getCheckInRecord());
            log.info("InsertSelective success");
            // update room status
            Room room = new Room();
            room.setRoomStatusID(3);
            roomService.updateByPrimaryKeySelective(room);
            log.info("InsertSelective - Room update success");
            return checkInRecordService.selectByPrimaryKey(param.getCheckInRecord().getCheckInRecordID());
        } catch (Exception e) {
            log.info("InsertSelective fail");
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
}
