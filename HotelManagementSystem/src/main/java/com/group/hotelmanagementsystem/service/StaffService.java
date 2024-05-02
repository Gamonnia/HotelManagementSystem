package com.group.hotelmanagementsystem.service;

import com.group.hotelmanagementsystem.entity.Staff;

import java.util.List;

public interface StaffService {
    int deleteByPrimaryKey(Integer staffID);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer staffID);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    List<Staff> selectAll();

    int alterTable();
}
