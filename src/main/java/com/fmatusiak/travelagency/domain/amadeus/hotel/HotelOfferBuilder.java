package com.fmatusiak.travelagency.domain.amadeus.hotel;

public class HotelOfferBuilder {
    private Hotel hotel;
    private HotelAddress hotelAddress;
    private HotelContact hotelContact;
    private HotelAmentities hotelAmentities;
    private HotelRoom hotelRoom;
    private HotelGuests hotelGuests;

    public HotelOfferBuilder setHotel(Hotel hotel) {
        this.hotel = hotel;
        return this;
    }

    public HotelOfferBuilder setHotelAddress(HotelAddress hotelAddress) {
        this.hotelAddress = hotelAddress;
        return this;
    }

    public HotelOfferBuilder setHotelContact(HotelContact hotelContact) {
        this.hotelContact = hotelContact;
        return this;
    }

    public HotelOfferBuilder setHotelAmentities(HotelAmentities hotelAmentities) {
        this.hotelAmentities = hotelAmentities;
        return this;
    }

    public HotelOfferBuilder setHotelRoom(HotelRoom hotelRoom) {
        this.hotelRoom = hotelRoom;
        return this;
    }

    public HotelOfferBuilder setHotelGuests(HotelGuests hotelGuests) {
        this.hotelGuests = hotelGuests;
        return this;
    }

    public HotelOffer createHotelOffer() {
        return new HotelOffer(hotel, hotelAddress, hotelContact, hotelAmentities, hotelRoom, hotelGuests);
    }
}