package com.group.hotelmanagementsystem.service;

import com.group.hotelmanagementsystem.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminService {
    Admin selectByPrimaryKey(Integer adminAccount);

    Admin login(Admin admin);

    int alterTable();
}
