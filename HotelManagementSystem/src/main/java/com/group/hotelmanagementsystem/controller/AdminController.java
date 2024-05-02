package com.group.hotelmanagementsystem.controller;

import com.group.hotelmanagementsystem.entity.Admin;
import com.group.hotelmanagementsystem.service.AdminService;
import com.group.hotelmanagementsystem.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login")
    public Map<String, Object> login(@RequestBody Admin admin) {
        log.info("Admin Login......");
        log.info("Admin Account: {}", admin.getAdminAccount());
        log.info("Admin Password: {}", admin.getAdminPassword());

        Map<String, Object> resultMap = new HashMap<>();

        try {
            Admin loginResult = adminService.login(admin);
            Map<String, String> payload = new HashMap<>();
            payload.put("adminAccount", String.valueOf(loginResult.getAdminAccount()));
            payload.put("adminPassword", loginResult.getAdminPassword());

            String token = JWTUtils.getToken(payload);
            resultMap.put("state", true);
            resultMap.put("token", token);
            resultMap.put("msg", "success");
        } catch (Exception e) {
            resultMap.put("state", false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

}
