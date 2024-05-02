package com.group.hotelmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * RoomStatus
 * @author 
 */
@Data
public class RoomStatus implements Serializable {
    private Integer roomStatusID;

    private String roomStatusName;

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "roomStatusID")
    public Integer getRoomStatusID() {
        return roomStatusID;
    }

    @JsonProperty(value = "roomStatusID")
    public void setRoomStatusID(Integer roomStatusID) {
        this.roomStatusID = roomStatusID;
    }

    @JsonProperty(value = "roomStatusName")
    public String getRoomStatusName() {
        return roomStatusName;
    }

    @JsonProperty(value = "roomStatusName")
    public void setRoomStatusName(String roomStatusName) {
        this.roomStatusName = roomStatusName;
    }
}