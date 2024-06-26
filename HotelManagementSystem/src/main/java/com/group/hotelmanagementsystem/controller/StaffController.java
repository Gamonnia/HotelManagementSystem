package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.Admin;
import com.group.hotelmanagementsystem.entity.Staff;
import com.group.hotelmanagementsystem.service.AdminService;
import com.group.hotelmanagementsystem.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/deleteByPrimaryKey")
    public boolean deleteByPrimaryKey(@RequestParam("staffID") Integer staffID) {
        try {
            adminService.deleteByPrimaryKey(staffID);
            staffService.deleteByPrimaryKey(staffID);
            log.info("Delete staffID: {}, success.", staffID);
            adminService.alterTable();
            staffService.alterTable();
            log.info("Alter table Staff & Admin increment success.");
            return true;
        } catch (Exception e) {
            log.info("Delete Staff or Alter Table failed.");
            log.error(e.getMessage());
            return false;
        }
    }


    @RequestMapping(value = "/insert")
    public Staff insert(@RequestBody Staff record) {
        try {
            staffService.insert(record);
            log.info("Insert staff success.");

            log.info("Insert - Create Admin Account.......");
            Admin admin = new Admin();
            // default AdminAccount & Password
            admin.setAdminAccount(record.getStaffID());
            admin.setAdminPassword(record.getStaffID().toString());
            adminService.insert(admin);
            log.info("Insert - Create Admin Account success.");

            return staffService.selectByPrimaryKey(record.getStaffID());
        } catch (Exception e) {
            log.info("Insert staff failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/insertSelective")
    public Staff insertSelective(@RequestBody Staff record) {
        try {
            staffService.insertSelective(record);
            log.info("InsertSelective staff success.");

            log.info("InsertSelective - Create Admin Account.......");
            Admin admin = new Admin();
            // default AdminAccount & Password
            admin.setAdminAccount(record.getStaffID());
            admin.setAdminPassword(record.getStaffID().toString());
            adminService.insert(admin);
            log.info("InsertSelective - Create Admin Account success.");

            return staffService.selectByPrimaryKey(record.getStaffID());
        } catch (Exception e) {
            log.info("InsertSelective staff failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/selectByPrimaryKey")
    public Staff selectByPrimaryKey(@RequestParam("staffID") Integer staffID) {
        try {
            log.info("staffID: {}", staffID);
            return staffService.selectByPrimaryKey(staffID);
        } catch (Exception e) {
            log.info("SelectByPrimaryKey staffID={} failed.", staffID);
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective")
    public Staff updateByPrimaryKeySelective(@RequestBody Staff record) {
        try {
            staffService.updateByPrimaryKeySelective(record);
            log.info("updateSelective staffID={} success.", record.getStaffID());
            return staffService.selectByPrimaryKey(record.getStaffID());
        } catch (Exception e) {
            log.info("updateSelective staffID={} failed.", record.getStaffID());
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/updateByPrimaryKey")
    public Staff updateByPrimaryKey(@RequestBody Staff record) {
        try {
            staffService.updateByPrimaryKey(record);
            log.info("update staffID={} success.", record.getStaffID());
            return staffService.selectByPrimaryKey(record.getStaffID());
        } catch (Exception e) {
            log.info("update staffID={} failed.", record.getStaffID());
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/selectAll")
    public List<Staff> selectAll() {
        try {
            log.info("selectAll Staff table");
            return staffService.selectAll();
        } catch (Exception e) {
            log.info("selectAll Staff table failed.");
            log.error(e.getMessage());
            return null;
        }
    }
}
