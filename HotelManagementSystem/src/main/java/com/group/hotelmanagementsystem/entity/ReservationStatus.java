package com.group.hotelmanagementsystem.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * ReservationStatus
 * @author gamonnia
 */
@Data
public class ReservationStatus implements Serializable {
    private Integer reservationStatusID;

    private String reservationStatusName;

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "reservationStatusID")
    public Integer getReservationStatusID() {
        return reservationStatusID;
    }

    @JsonProperty(value = "reservationStatusID")
    public void setReservationStatusID(Integer reservationStatusID) {
        this.reservationStatusID = reservationStatusID;
    }

    @JsonProperty(value = "reservationStatusName")
    public String getReservationStatusName() {
        return reservationStatusName;
    }

    @JsonProperty(value = "reservationStatusName")
    public void setReservationStatusName(String reservationStatusName) {
        this.reservationStatusName = reservationStatusName;
    }
}
