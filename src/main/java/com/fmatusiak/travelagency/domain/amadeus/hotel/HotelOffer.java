package com.fmatusiak.travelagency.domain.amadeus.hotel;

public class HotelOffer {
    private Hotel hotel;
    private HotelAddress hotelAddress;
    private HotelContact hotelContact;
    private HotelAmentities hotelAmentities;
    private HotelRoom hotelRoom;
    private HotelGuests hotelGuests;

    public HotelOffer(Hotel hotel, HotelAddress hotelAddress, HotelContact hotelContact, HotelAmentities hotelAmentities, HotelRoom hotelRoom, HotelGuests hotelGuests) {
        this.hotel = hotel;
        this.hotelAddress = hotelAddress;
        this.hotelContact = hotelContact;
        this.hotelAmentities = hotelAmentities;
        this.hotelRoom = hotelRoom;
        this.hotelGuests = hotelGuests;
    }
}
