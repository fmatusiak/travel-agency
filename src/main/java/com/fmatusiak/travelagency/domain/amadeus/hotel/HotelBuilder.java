package com.fmatusiak.travelagency.domain.amadeus.hotel;

public class HotelBuilder {
    private HotelProperty hotelProperty;
    private HotelAddress hotelAddress;
    private HotelContact hotelContact;
    private HotelAmentities hotelAmentities;

    public HotelBuilder setHotelProperty(HotelProperty hotelProperty) {
        this.hotelProperty = hotelProperty;
        return this;
    }

    public HotelBuilder setHotelAddress(HotelAddress hotelAddress) {
        this.hotelAddress = hotelAddress;
        return this;
    }

    public HotelBuilder setHotelContact(HotelContact hotelContact) {
        this.hotelContact = hotelContact;
        return this;
    }

    public HotelBuilder setHotelAmentities(HotelAmentities hotelAmentities) {
        this.hotelAmentities = hotelAmentities;
        return this;
    }

    public Hotel createHotel() {
        return new Hotel(hotelProperty, hotelAddress, hotelContact, hotelAmentities);
    }
}