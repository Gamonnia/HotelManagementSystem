package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.CheckInRecord;
import com.group.hotelmanagementsystem.entity.Customer;
import com.group.hotelmanagementsystem.service.CheckInRecordService;
import com.group.hotelmanagementsystem.service.CustomerService;
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

    @RequestMapping(value = "/deleteByPrimaryKey")
    public String deleteByPrimaryKey(@RequestParam("checkInRecordID") Integer checkInRecordID) {
        try {
            checkInRecordService.deleteByPrimaryKey(checkInRecordID);
            log.info("Delete checkInRecordID: {}, success.", checkInRecordID);
            checkInRecordService.alterTable();
            log.info("Alter table CheckInRecord increment success.");
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
            log.info("Insert checkInRecord success");
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
            log.info("InsertSelective success");
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
    public CheckInRecord updateByPrimaryKey(@RequestBody CheckInRecord record) {
        try{
            checkInRecordService.updateByPrimaryKey(record);
            log.info("update checkInRecordID={} success.", record.getCheckInRecordID());
            return checkInRecordService.selectByPrimaryKey(record.getCheckInRecordID());
        }catch (Exception e){
            log.info("update checkInRecordID={} failed.", record.getCheckInRecordID());
            log.error(e.getMessage());
            return checkInRecordService.selectByPrimaryKey(record.getCheckInRecordID());
        }
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective")
    public CheckInRecord updateByPrimaryKeySelective(@RequestBody CheckInRecord record) {
        try {
            checkInRecordService.updateByPrimaryKeySelective(record);
            log.info("updateSelective checkInRecordID={} success.", record.getCheckInRecordID());
            return checkInRecordService.selectByPrimaryKey(record.getCheckInRecordID());
        } catch (Exception e) {
            log.info("updateSelective checkInRecordID={} failed.", record.getCheckInRecordID());
            log.error(e.getMessage());
            return checkInRecordService.selectByPrimaryKey(record.getCheckInRecordID());
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
