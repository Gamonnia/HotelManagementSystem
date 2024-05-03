package com.group.hotelmanagementsystem.service;

import com.group.hotelmanagementsystem.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminService {
    int deleteByPrimaryKey(Integer adminAccount);

    int insert(Admin admin);

    int insertSelective(Admin admin);

    Admin selectByPrimaryKey(Integer adminAccount);

    int updateByPrimaryKeySelective(Admin admin);

    int updateByPrimaryKey(Admin admin);

    Admin login(Admin admin);

    int alterTable();
}
