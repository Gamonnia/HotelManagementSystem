package com.group.hotelmanagementsystem.service.implement;

import com.group.hotelmanagementsystem.entity.Customer;
import com.group.hotelmanagementsystem.mapper.CustomerMapper;
import com.group.hotelmanagementsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int deleteByPrimaryKey(Integer customerID) {
        return customerMapper.deleteByPrimaryKey(customerID);
    }

    @Override
    public int insert(Customer record) {
        return customerMapper.insert(record);
    }

    @Override
    public int insertSelective(Customer record) {
        return customerMapper.insertSelective(record);
    }

    @Override
    public Customer selectByPrimaryKey(Integer customerID) {
        return customerMapper.selectByPrimaryKey(customerID);
    }

    @Override
    public Customer selectCustomer(Customer customer) {
        return customerMapper.selectCustomer(customer);
    }

    @Override
    public int updateByPrimaryKeySelective(Customer record) {
        return customerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Customer record) {
        return customerMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Customer> selectAll() {
        return customerMapper.selectAll();
    }

    @Override
    public int alterTable() {
        return customerMapper.alterTable();
    }
}
