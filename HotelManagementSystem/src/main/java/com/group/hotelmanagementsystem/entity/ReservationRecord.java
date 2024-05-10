package com.group.hotelmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * ReservationRecord
 * @author gamonnia
 */
@Data
public class ReservationRecord implements Serializable {
    private Integer reservationRecordID;

    private String customerName;

    private String customerPhone;

    private Integer roomTypeID;

    private Date expectedCheckIn;

    private Integer staffID;

    private Date recordTime;

    private Integer reservationStatusID = 1;

    private RoomType roomType;

    private ReservationStatus reservationStatus;

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "reservationRecordID")
    public Integer getReservationRecordID() {
        return reservationRecordID;
    }
    @JsonProperty(value = "reservationRecordID")
    public void setReservationRecordID(Integer reservationRecordID) {
        this.reservationRecordID = reservationRecordID;
    }

    @JsonProperty(value = "customerName")
    public String getCustomerName() {
        return customerName;
    }

    @JsonProperty(value = "customerName")
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @JsonProperty(value = "customerPhone")
    public String getCustomerPhone() {
        return customerPhone;
    }

    @JsonProperty(value = "customerPhone")
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @JsonProperty(value = "roomTypeID")
    public Integer getRoomTypeID() {
        return roomTypeID;
    }

    @JsonProperty(value = "roomTypeID")
    public void setRoomTypeID(Integer roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    @JsonProperty(value = "expectedCheckIn")
    public Date getExpectedCheckIn() {
        return expectedCheckIn;
    }

    @JsonProperty(value = "expectedCheckIn")
    public void setExpectedCheckIn(Date expectedCheckIn) {
        this.expectedCheckIn = expectedCheckIn;
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

    @JsonProperty(value = "roomType")
    public RoomType getRoomType() {
        return roomType;
    }

    @JsonProperty(value = "roomType")
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @JsonProperty(value = "reservationStatusID")
    public Integer getReservationStatusID() {
        return reservationStatusID;
    }

    @JsonProperty(value = "reservationStatusID", defaultValue = "1")
    public void setReservationStatusID(Integer reservationStatusID) {
        this.reservationStatusID = reservationStatusID;
    }

    @JsonProperty(value = "reservationStatus")
    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    @JsonProperty(value = "reservationStatus")
    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}