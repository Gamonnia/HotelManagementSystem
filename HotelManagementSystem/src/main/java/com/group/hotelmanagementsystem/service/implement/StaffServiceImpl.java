package com.group.hotelmanagementsystem.service.implement;

import com.group.hotelmanagementsystem.entity.Staff;
import com.group.hotelmanagementsystem.mapper.StaffMapper;
import com.group.hotelmanagementsystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public int deleteByPrimaryKey(Integer staffID) {
        return staffMapper.deleteByPrimaryKey(staffID);
    }

    @Override
    public int insert(Staff record) {
        return staffMapper.insert(record);
    }

    @Override
    public int insertSelective(Staff record) {
        return staffMapper.insertSelective(record);
    }

    @Override
    public Staff selectByPrimaryKey(Integer staffID) {
        return staffMapper.selectByPrimaryKey(staffID);
    }

    @Override
    public int updateByPrimaryKeySelective(Staff record) {
        return staffMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Staff record) {
        return staffMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Staff> selectAll() {
        return staffMapper.selectAll();
    }

    @Override
    public int alterTable() {
        return staffMapper.alterTable();
    }
}
