package com.group.hotelmanagementsystem.service;

import com.group.hotelmanagementsystem.entity.Customer;

import java.util.List;

public interface CustomerService {
    int deleteByPrimaryKey(Integer customerID);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer customerID);

    Customer selectCustomer(Customer customer);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    List<Customer> selectAll();

    int alterTable();
}
