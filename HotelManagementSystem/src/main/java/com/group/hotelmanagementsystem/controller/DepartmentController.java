package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.Department;
import com.group.hotelmanagementsystem.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/deleteByPrimaryKey")
    public String deleteByPrimaryKey(@RequestParam("departmentID") Integer departmentID) {
        try {
            departmentService.deleteByPrimaryKey(departmentID);
            log.info("Delete departmentID: {}, success.", departmentID);
            departmentService.alterTable();
            log.info("Alter table Department increment success.");
            return "Delete departmentID: " + departmentID + " success.";
        } catch (Exception e) {
            log.info("Delete Department or Alter table failed.");
            log.error(e.getMessage());
            return "Delete departmentID: " + departmentID + " failed.";
        }
    }


    @RequestMapping(value = "/insert")
    public Department insert(@RequestBody Department record) {
        try {
            if (departmentService.selectByDepartmentName(record.getDepartmentName()) != null) {
                log.info("Insert - Department already exist.");
                return null;
            }
            departmentService.insert(record);
            log.info("Insert Department success.");
            return departmentService.selectByPrimaryKey(record.getDepartmentID());
        } catch (Exception e) {
            log.info("Insert Department failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/insertSelective")
    public Department insertSelective(@RequestBody Department record) {
        try {
            if (departmentService.selectByDepartmentName(record.getDepartmentName()) != null) {
                log.info("InsertSelective - Department already exist.");
                return null;
            }
            departmentService.insertSelective(record);
            log.info("InsertSelective Department success.");
            return departmentService.selectByPrimaryKey(record.getDepartmentID());
        } catch (Exception e) {
            log.info("InsertSelective Department failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/selectByPrimaryKey")
    public Department selectByPrimaryKey(@RequestParam("departmentID") Integer departmentID) {
        try {
            log.info("departmentID: {}", departmentID);
            return departmentService.selectByPrimaryKey(departmentID);
        } catch (Exception e) {
            log.info("SelectByPrimary departmentID={} failed.", departmentID);
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping(value = "/updatePrimaryKeySelective")
    public Department updateByPrimaryKeySelective(@RequestBody Department record) {
        try {
            departmentService.updateByPrimaryKeySelective(record);
            log.info("updateSelective departmentID={} success.", record.getDepartmentID());
            return departmentService.selectByPrimaryKey(record.getDepartmentID());
        } catch (Exception e) {
            log.info("updateSelective departmentID={} failed.", record.getDepartmentID());
            log.error(e.getMessage());
            return departmentService.selectByPrimaryKey(record.getDepartmentID());
        }
    }


    @RequestMapping(value = "/updateByPrimaryKey")
    public Department updateByPrimaryKey(@RequestBody Department record) {
        try {
            departmentService.updateByPrimaryKey(record);
            log.info("update departmentID={} success.", record.getDepartmentID());
            return departmentService.selectByPrimaryKey(record.getDepartmentID());
        } catch (Exception e) {
            log.info("update departmentID={} failed.", record.getDepartmentID());
            log.error(e.getMessage());
            return departmentService.selectByPrimaryKey(record.getDepartmentID());
        }
    }


    @RequestMapping(value = "/selectAll")
    public List<Department> selectAll() {
        try {
            log.info("selectAll Department table");
            return departmentService.selectAll();
        } catch (Exception e) {
            log.info("selectAll Department table failed.");
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
