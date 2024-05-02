package com.group.hotelmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * Customer
 * @author 
 */
@Data
public class Customer implements Serializable {
    private Integer customerID;

    private String customerName;

    private String gender;

    private String IDNumber;

    private String phoneNumber;

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "customerID")
    public Integer getCustomerID() {
        return customerID;
    }

    @JsonProperty(value = "customerID")
    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    @JsonProperty(value = "customerName")
    public String getCustomerName() {
        return customerName;
    }

    @JsonProperty(value = "customerName")
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @JsonProperty(value = "gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty(value = "gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty(value = "IDNumber")
    public String getIDNumber() {
        return IDNumber;
    }

    @JsonProperty(value = "IDNumber")
    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    @JsonProperty(value = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty(value = "phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}