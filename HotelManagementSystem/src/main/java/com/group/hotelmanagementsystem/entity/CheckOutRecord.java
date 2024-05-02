package com.group.hotelmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * CheckOutRecord
 * @author 
 */
@Data
public class CheckOutRecord implements Serializable {
    private Integer checkOutRecordID;

    private Integer customerID;

    private Integer roomID;

    private Date checkInTime;

    private Date checkOutTime;

    private Integer staffID;

    private Date recordTime;

    private Customer customer;

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "checkOutRecordID")
    public Integer getCheckOutRecordID() {
        return checkOutRecordID;
    }

    @JsonProperty(value = "checkOutRecordID")
    public void setCheckOutRecordID(Integer checkOutRecordID) {
        this.checkOutRecordID = checkOutRecordID;
    }

    @JsonProperty(value = "customerID")
    public Integer getCustomerID() {
        return customerID;
    }

    @JsonProperty(value = "customerID")
    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    @JsonProperty(value = "roomID")
    public Integer getRoomID() {
        return roomID;
    }

    @JsonProperty(value = "roomID")
    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    @JsonProperty(value = "checkInTime")
    public Date getCheckInTime() {
        return checkInTime;
    }

    @JsonProperty(value = "checkInTime")
    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    @JsonProperty(value = "checkOutTime")
    public Date getCheckOutTime() {
        return checkOutTime;
    }

    @JsonProperty(value = "checkOutTime")
    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    @JsonProperty(value = "staffID")
    public Integer getStaffID() {
        return staffID;
    }

    @JsonProperty(value = "staffID")
    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

    @JsonProperty(value = "recordTime")
    public Date getRecordTime() {
        return recordTime;
    }

    @JsonProperty(value = "recordTime")
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    @JsonProperty(value = "customer")
    public Customer getCustomer() {
        return customer;
    }

    @JsonProperty(value = "customer")
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}