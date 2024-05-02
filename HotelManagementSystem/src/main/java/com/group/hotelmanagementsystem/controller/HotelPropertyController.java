package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.HotelProperty;
import com.group.hotelmanagementsystem.service.HotelPropertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("hotelPropertyController")
public class HotelPropertyController {

    @Autowired
    private HotelPropertyService hotelPropertyService;

    @RequestMapping("/deleteByPrimaryKey")
    public String deleteByPrimaryKey(@RequestParam("itemID") Integer itemID) {
        try {
            hotelPropertyService.deleteByPrimaryKey(itemID);
            log.info("Delete itemID: {}, success.", itemID);
            hotelPropertyService.alterTable();
            log.info("Alter table HotelProperty increment success.");
            return "Delete itemID: " + itemID + " success.";
        } catch (Exception e) {
            log.info("Delete HotelProperty or Alter Table failed.");
            log.error(e.getMessage());
            return "Delete itemID: " + itemID + " failed.";
        }
    }


    @RequestMapping("/insert")
    public HotelProperty insert(@RequestBody HotelProperty record) {
        try {
            hotelPropertyService.insert(record);
            log.info("Insert HotelProperty success.");
            return hotelPropertyService.selectByPrimaryKey(record.getItemID());
        } catch (Exception e) {
            log.info("Insert HotelProperty failed.");
            log.error(e.getMessage());
            return null;
        }
    }

    @RequestMapping("/insertSelective")
    public HotelProperty insertSelective(@RequestBody HotelProperty record) {
        try {
            hotelPropertyService.insertSelective(record);
            log.info("InsertSelective HotelProperty success.");
            return hotelPropertyService.selectByPrimaryKey(record.getItemID());
        } catch (Exception e) {
            log.info("InsertSelective HotelProperty failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping("/selectByPrimaryKey")
    public HotelProperty selectByPrimaryKey(@RequestParam("itemID") Integer itemID) {
        try {
            log.info("itemID: {}", itemID);
            return hotelPropertyService.selectByPrimaryKey(itemID);
        } catch (Exception e) {
            log.info("selectByPrimaryKey itemID={} failed.", itemID);
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping("/updateByPrimaryKeySelective")
    public HotelProperty updateByPrimaryKeySelective(@RequestBody HotelProperty record) {
        try {
            hotelPropertyService.updateByPrimaryKeySelective(record);
            log.info("updateSelective itemID={}, success.", record.getItemID());
            return hotelPropertyService.selectByPrimaryKey(record.getItemID());
        } catch (Exception e) {
            log.info("updateSelective itemID={}, failed.", record.getItemID());
            log.error(e.getMessage());
            return hotelPropertyService.selectByPrimaryKey(record.getItemID());
        }
    }


    @RequestMapping("/updateByPrimaryKey")
    public HotelProperty updateByPrimaryKey(@RequestBody HotelProperty record) {
        try {
            hotelPropertyService.updateByPrimaryKey(record);
            log.info("update itemID={}, success.", record.getItemID());
            return hotelPropertyService.selectByPrimaryKey(record.getItemID());
        } catch (Exception e) {
            log.info("update itemID={}, failed.", record.getItemID());
            log.error(e.getMessage());
            return hotelPropertyService.selectByPrimaryKey(record.getItemID());
        }
    }


    @RequestMapping("/selectAll")
    public List<HotelProperty> selectAll() {
        try {
            log.info("selectAll HotelProperty table.");
            return hotelPropertyService.selectAll();
        } catch (Exception e) {
            log.info("selectAll HotelProperty table failed.");
            log.error(e.getMessage());
            return null;
        }
    }
}
