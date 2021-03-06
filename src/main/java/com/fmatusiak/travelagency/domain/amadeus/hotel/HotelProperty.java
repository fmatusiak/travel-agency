package com.fmatusiak.travelagency.domain.amadeus.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HotelProperty {
    private String hotelId;
    private String chainCode;
    private String name;
    private int rating;
    private String cityCode;
}
