package com.fmatusiak.travelagency.domain.amadeus.hotel;

import lombok.Getter;

@Getter
public class HotelPersonalize {
    private String cityCode;
    private String checkInDate;
    private String checkOutDate;
    private int roomQuantity;
    private int adults;

    public HotelPersonalize(String cityCode, String checkInDate, String checkOutDate, int roomQuantity, int adults) {
        this.cityCode = cityCode;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomQuantity = roomQuantity;
        this.adults = adults;
    }
}
