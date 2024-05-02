package com.group.hotelmanagementsystem.mapper;

import com.group.hotelmanagementsystem.entity.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaffMapper {
    int deleteByPrimaryKey(Integer staffID);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer staffID);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    List<Staff> selectAll();

    int alterTable();
}