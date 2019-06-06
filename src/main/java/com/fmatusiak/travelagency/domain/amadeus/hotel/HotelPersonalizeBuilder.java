package com.fmatusiak.travelagency.domain.amadeus.hotel;

public class HotelPersonalizeBuilder {
    private String cityCode;
    private String checkInDate;
    private String checkOutDate;
    private int roomQuantity;
    private int adults;

    public HotelPersonalizeBuilder setCityCode(String cityCode) {
        this.cityCode = cityCode;
        return this;
    }

    public HotelPersonalizeBuilder setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
        return this;
    }

    public HotelPersonalizeBuilder setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
        return this;
    }

    public HotelPersonalizeBuilder setRoomQuantity(int roomQuantity) {
        this.roomQuantity = roomQuantity;
        return this;
    }

    public HotelPersonalizeBuilder setAdults(int adults) {
        this.adults = adults;
        return this;
    }

    public HotelPersonalize createHotelPersonalize() {
        return new HotelPersonalize(cityCode, checkInDate, checkOutDate, roomQuantity, adults);
    }
}