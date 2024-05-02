package com.group.hotelmanagementsystem.mapper;

import com.group.hotelmanagementsystem.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    int deleteByPrimaryKey(Integer adminAccount);

    int insert(Admin admin);

    int insertSelective(Admin admin);

    Admin selectByPrimaryKey(Integer adminAccount);

    int updateByPrimaryKeySelective(Admin admin);

    int updateByPrimaryKey(Admin admin);

    Admin login(Admin admin);

    int alterTable();
}