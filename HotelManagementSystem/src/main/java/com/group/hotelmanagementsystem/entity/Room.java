package com.group.hotelmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * Room
 * @author 
 */
@Data
public class Room implements Serializable {
    private Integer roomID;

    private Integer roomTypeID;

    private Integer roomStatusID;

    private RoomType roomType;

    private RoomStatus roomStatus;

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "roomID")
    public Integer getRoomID() {
        return roomID;
    }

    @JsonProperty(value = "roomID")
    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    @JsonProperty(value = "roomTypeID")
    public Integer getRoomTypeID() {
        return roomTypeID;
    }

    @JsonProperty(value = "roomTypeID")
    public void setRoomTypeID(Integer roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    @JsonProperty(value = "roomStatusID")
    public Integer getRoomStatusID() {
        return roomStatusID;
    }

    @JsonProperty(value = "roomStatusID")
    public void setRoomStatusID(Integer roomStatusID) {
        this.roomStatusID = roomStatusID;
    }

    @JsonProperty(value = "roomType")
    public RoomType getRoomType() {
        return roomType;
    }

    @JsonProperty(value = "roomType")
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @JsonProperty(value = "roomStatus")
    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    @JsonProperty(value = "roomStatus")
    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }
}