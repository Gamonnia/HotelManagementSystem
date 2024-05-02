package com.group.hotelmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * Department
 * @author 
 */
@Data
public class Department implements Serializable {

    private Integer departmentID;

    private String departmentName;

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "departmentID")
    public Integer getDepartmentID() {
        return departmentID;
    }

    @JsonProperty(value = "checkOutRecordID")
    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    @JsonProperty(value = "departmentName")
    public String getDepartmentName() {
        return departmentName;
    }

    @JsonProperty(value = "departmentName")
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}