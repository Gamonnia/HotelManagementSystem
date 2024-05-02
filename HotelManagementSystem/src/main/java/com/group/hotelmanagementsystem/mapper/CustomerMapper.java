package com.group.hotelmanagementsystem.mapper;

import com.group.hotelmanagementsystem.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
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