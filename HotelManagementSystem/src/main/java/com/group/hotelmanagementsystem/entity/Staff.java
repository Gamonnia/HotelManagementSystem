package com.group.hotelmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Staff
 * @author 
 */
@Data
public class Staff implements Serializable {
    private Integer staffID;

    private String staffName;

    private String position;

    private BigDecimal salary;

    private Integer departmentID;

    private String gender;

    private Department department;

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "staffID")
    public Integer getStaffID() {
        return staffID;
    }

    @JsonProperty(value = "staffID")
    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

    @JsonProperty(value = "staffName")
    public String getStaffName() {
        return staffName;
    }

    @JsonProperty(value = "staffName")
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @JsonProperty(value = "position")
    public String getPosition() {
        return position;
    }

    @JsonProperty(value = "position")
    public void setPosition(String position) {
        this.position = position;
    }

    @JsonProperty(value = "salary")
    public BigDecimal getSalary() {
        return salary;
    }

    @JsonProperty(value = "salary")
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @JsonProperty(value = "departmentID")
    public Integer getDepartmentID() {
        return departmentID;
    }

    @JsonProperty(value = "departmentID")
    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    @JsonProperty(value = "gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty(value = "gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty(value = "department")
    public Department getDepartment() {
        return department;
    }

    @JsonProperty(value = "department")
    public void setDepartment(Department department) {
        this.department = department;
    }
}