package com.group.hotelmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * HotelProperty
 * @author 
 */
@Data
public class HotelProperty implements Serializable {
    private Integer itemID;

    private String itemType;

    private Integer itemQuantity;

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "itemID")
    public Integer getItemID() {
        return itemID;
    }

    @JsonProperty(value = "itemID")
    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    @JsonProperty(value = "itemType")
    public String getItemType() {
        return itemType;
    }

    @JsonProperty(value = "itemType")
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @JsonProperty(value = "itemQuantity")
    public Integer getItemQuantity() {
        return itemQuantity;
    }

    @JsonProperty(value = "itemQuantity")
    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}