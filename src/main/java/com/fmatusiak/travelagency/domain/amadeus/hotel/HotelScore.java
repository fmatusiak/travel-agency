package com.fmatusiak.travelagency.domain.amadeus.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HotelScore {
    private HotelProperty hotelProperty;
    private HotelAddress hotelAddress;
    private HotelContact hotelContact;
    private HotelAmentities hotelAmentities;
}
