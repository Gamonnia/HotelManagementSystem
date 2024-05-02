package com.group.hotelmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * CheckInRecord
 * @author
 */
@Data
public class CheckInRecord implements Serializable {
    private Integer checkInRecordID;

    private Integer customerID;

    private Integer roomID;

    private Date checkInTime;

    private Date expectedCheckOut;

    private BigDecimal deposit;

    private BigDecimal paymentAmount;

    private Integer staffID;

    private Date recordTime;

    private Customer customer;

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "checkInRecordID")
    public Integer getCheckInRecordID() {
        return checkInRecordID;
    }

    @JsonProperty(value = "checkInRecordID")
    public void setCheckInRecordID(Integer checkInRecordID) {
        this.checkInRecordID = checkInRecordID;
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

    @JsonProperty(value = "expectedCheckOut")
    public Date getExpectedCheckOut() {
        return expectedCheckOut;
    }

    @JsonProperty(value = "expectedCheckOut")
    public void setExpectedCheckOut(Date expectedCheckOut) {
        this.expectedCheckOut = expectedCheckOut;
    }

    @JsonProperty(value = "deposit")
    public BigDecimal getDeposit() {
        return deposit;
    }

    @JsonProperty(value = "deposit")
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    @JsonProperty(value = "paymentAmount")
    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    @JsonProperty(value = "paymentAmount")
    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
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