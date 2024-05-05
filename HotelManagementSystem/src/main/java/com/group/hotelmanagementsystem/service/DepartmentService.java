package com.group.hotelmanagementsystem.service;

import com.group.hotelmanagementsystem.entity.Department;

import java.util.List;


public interface DepartmentService {
    int deleteByPrimaryKey(Integer departmentID);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer departmentID);

    Department selectByDepartmentName(String departmentName);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> selectAll();

    int alterTable();
}
