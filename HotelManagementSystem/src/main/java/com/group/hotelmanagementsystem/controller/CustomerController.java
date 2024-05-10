package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.Customer;

import com.group.hotelmanagementsystem.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/deleteByPrimaryKey")
    public boolean deleteByPrimaryKey(@RequestParam("customerID") Integer customerID) {
        try {
            customerService.deleteByPrimaryKey(customerID);
            log.info("Delete customerID: {}, success.", customerID);
            customerService.alterTable();
            log.info("Alter table Customer increment success.");
            return true;
        } catch (Exception e) {
            log.info("Delete Customer or Alter Table failed.");
            log.error(e.getMessage());
            return false;
        }
    }


    @RequestMapping("/insert")
    public Customer insert(@RequestBody Customer record) {
        try {
            customerService.insert(record);
            log.info("Insert customer success.");
            return customerService.selectByPrimaryKey(record.getCustomerID());
        } catch (Exception e) {
            log.info("Insert customer failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping("/insertSelective")
    public Customer insertSelective(@RequestBody Customer record) {
        try {
            customerService.insertSelective(record);
            log.info("InsertSelective customer success.");
            return customerService.selectByPrimaryKey(record.getCustomerID());
        } catch (Exception e) {
            log.info("InsertSelective customer failed.");
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping("/selectByPrimaryKey")
    public Customer selectByPrimaryKey(@RequestParam("customerID") Integer customerID) {
        try {
            log.info("customerID: {}", customerID);
            return customerService.selectByPrimaryKey(customerID);
        } catch (Exception e) {
            log.info("SelectByPrimaryKey customerID={} failed.", customerID);
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping("/selectCustomer")
    public Customer selectCustomer(@RequestBody Customer customer) {
        try {
            log.info("verify customerID: {}", customer.getCustomerID());
            return customerService.selectCustomer(customer);
        } catch (Exception e) {
            log.info("verify customerID={} failed.", customer.getCustomerID());
            log.error(e.getMessage());
            return null;
        }
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Customer updateByPrimaryKeySelective(@RequestBody Customer record) {
        try {
            customerService.updateByPrimaryKeySelective(record);
            log.info("updateSelective customerID={} success.", record.getCustomerID());
            return customerService.selectByPrimaryKey(record.getCustomerID());
        } catch (Exception e) {
            log.info("updateSelective customerID={} failed.", record.getCustomerID());
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping("/updateByPrimaryKey")
    public Customer updateByPrimaryKey(@RequestBody Customer record) {
        try {
            customerService.updateByPrimaryKey(record);
            log.info("update customerID={} success.", record.getCustomerID());
            return customerService.selectByPrimaryKey(record.getCustomerID());
        } catch (Exception e) {
            log.info("update customerID={} failed.", record.getCustomerID());
            log.error(e.getMessage());
            return null;
        }
    }


    @RequestMapping("/selectAll")
    public List<Customer> selectAll() {
        try {
            log.info("selectAll Customer table");
            return customerService.selectAll();
        } catch (Exception e) {
            log.info("selectAll Customer table failed.");
            log.error(e.getMessage());
            return null;
        }
    }
}
