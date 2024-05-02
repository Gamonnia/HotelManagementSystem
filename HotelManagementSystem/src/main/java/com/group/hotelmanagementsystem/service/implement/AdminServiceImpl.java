package com.group.hotelmanagementsystem.service.implement;


import com.group.hotelmanagementsystem.entity.Admin;
import com.group.hotelmanagementsystem.mapper.AdminMapper;
import com.group.hotelmanagementsystem.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin selectByPrimaryKey(Integer adminAccount) {
        return adminMapper.selectByPrimaryKey(adminAccount);
    }

    @Override
    public Admin login(Admin admin) {
        Admin loginResult = adminMapper.login(admin);
        if (loginResult != null) {
            log.info("Login Success");
            return loginResult;
        }
        log.info("Login Failed");
        return null;
    }

    @Override
    public int alterTable() {
        return adminMapper.alterTable();
    }
}
