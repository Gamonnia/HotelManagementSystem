package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.FinancialRecord;
import com.group.hotelmanagementsystem.service.FinancialRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("financialRecord")
public class FinancialRecordController {

    @Autowired
    private FinancialRecordService financialRecordService;

    @RequestMapping("/deleteByPrimaryKey")
    public boolean deleteByPrimaryKey(@RequestParam("financialRecordID") Integer financialRecordID) {
        try {
            financialRecordService.deleteByPrimaryKey(financialRecordID);
            log.info("Delete financialID: {}, success.", financialRecordID);
            financialRecordService.alterTable();
            log.info("Alter table FinancialRecord increment success.");
            return true;
        } catch (Exception e) {
            log.info("Delete FinancialRecord or Alter table failed.");
            log.error(e.getMessage());
            return false;
        }
    }


    @RequestMapping("/insert")
    public FinancialRecord insert(@RequestBody FinancialRecord record) {
        try {
            financialRecordService.insert(record);
            log.info("Insert financialRecord success.");
            return financialRecordService.selectByPrimaryKey(record.getFinancialRecordID());
        } catch (Exception e) {
            log.info("Insert financialRecord failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping("/insertSelective")
    public FinancialRecord insertSelective(@RequestBody FinancialRecord record) {
        try {
            financialRecordService.insertSelective(record);
            log.info("InsertSelective financialRecord success.");
            return financialRecordService.selectByPrimaryKey(record.getFinancialRecordID());
        } catch (Exception e) {
            log.info("InsertSelective financialRecord failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping("/selectByPrimaryKey")
    public FinancialRecord selectByPrimaryKey(@RequestParam("financialRecordID") Integer financialRecordID) {
        try {
            log.info("FinancialRecordID: {}", financialRecordID);
            return financialRecordService.selectByPrimaryKey(financialRecordID);
        } catch (Exception e) {
            log.info("SelectByPrimaryKey financialRecordID={} failed.", financialRecordID);
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping("/updateByPrimaryKeySelective")
    public FinancialRecord updateByPrimaryKeySelective(@RequestBody FinancialRecord record) {
        try {
            financialRecordService.updateByPrimaryKeySelective(record);
            log.info("updateSelective financialRecordID={} success.", record.getFinancialRecordID());
            return financialRecordService.selectByPrimaryKey(record.getFinancialRecordID());
        } catch (Exception e) {
            log.info("updateSelective financialRecordID={} failed.", record.getFinancialRecordID());
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping("updateByPrimaryKey")
    public FinancialRecord updateByPrimaryKey(@RequestBody FinancialRecord record) {
        try {
            financialRecordService.updateByPrimaryKey(record);
            log.info("update financialRecordID={} success.", record.getFinancialRecordID());
            return financialRecordService.selectByPrimaryKey(record.getFinancialRecordID());
        } catch (Exception e) {
            log.info("update financialRecordID={} failed.", record.getFinancialRecordID());
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping("/selectAll")
    public List<FinancialRecord> selectAll() {
        try {
            log.info("selectAll FinancialRecord table");
            return financialRecordService.selectAll();
        } catch (Exception e) {
            log.info("selectAll FinancialRecord table failed.");
            log.error(e.getMessage());
            return null;
        }
    }
}
