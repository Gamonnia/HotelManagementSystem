package com.group.hotelmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Admin
 * @author group8
 */
@Data
public class Admin implements Serializable {
    private Integer adminAccount;

    private String adminPassword;

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "adminAccount")
    public Integer getAdminAccount() {
        return adminAccount;
    }

    @JsonProperty(value = "adminAccount")
    public void setAdminAccount(Integer adminAccount) {
        this.adminAccount = adminAccount;
    }

    @JsonProperty(value = "adminPassword")
    public String getAdminPassword() {
        return adminPassword;
    }

    @JsonProperty(value = "adminPassword")
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}