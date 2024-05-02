package com.group.hotelmanagementsystem.service.implement;

import com.group.hotelmanagementsystem.entity.Department;
import com.group.hotelmanagementsystem.mapper.DepartmentMapper;
import com.group.hotelmanagementsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired private DepartmentMapper departmentMapper;

    @Override
    public int deleteByPrimaryKey(Integer departmentID) {
        return departmentMapper.deleteByPrimaryKey(departmentID);
    }

    @Override
    public int insert(Department record) {
        return departmentMapper.insert(record);
    }

    @Override
    public int insertSelective(Department record) {
        return departmentMapper.insertSelective(record);
    }

    @Override
    public Department selectByPrimaryKey(Integer departmentID) {
        return departmentMapper.selectByPrimaryKey(departmentID);
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return departmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return departmentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Department> selectAll() {
        return departmentMapper.selectAll();
    }

    @Override
    public int alterTable() {
        return departmentMapper.alterTable();
    }
}
