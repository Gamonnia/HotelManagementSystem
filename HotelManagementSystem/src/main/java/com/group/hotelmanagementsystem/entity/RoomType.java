package com.group.hotelmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * RoomType
 * @author 
 */
@Data
public class RoomType implements Serializable {
    private Integer roomTypeID;

    private String roomTypeName;

    private BigDecimal roomPrice;

    private BigDecimal roomDeposit;

    private BigDecimal roomSize;

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "roomTypeID")
    public Integer getRoomTypeID() {
        return roomTypeID;
    }

    @JsonProperty(value = "roomTypeID")
    public void setRoomTypeID(Integer roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    @JsonProperty(value = "roomTypeName")
    public String getRoomTypeName() {
        return roomTypeName;
    }

    @JsonProperty(value = "roomTypeName")
    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    @JsonProperty(value = "roomPrice")
    public BigDecimal getRoomPrice() {
        return roomPrice;
    }

    @JsonProperty(value = "roomPrice")
    public void setRoomPrice(BigDecimal roomPrice) {
        this.roomPrice = roomPrice;
    }

    @JsonProperty(value = "roomDeposit")
    public BigDecimal getRoomDeposit() {
        return roomDeposit;
    }

    @JsonProperty(value = "roomDeposit")
    public void setRoomDeposit(BigDecimal roomDeposit) {
        this.roomDeposit = roomDeposit;
    }

    @JsonProperty(value = "roomSize")
    public BigDecimal getRoomSize() {
        return roomSize;
    }

    @JsonProperty(value = "roomSize")
    public void setRoomSize(BigDecimal roomSize) {
        this.roomSize = roomSize;
    }
}