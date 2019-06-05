package com.fmatusiak.travelagency.domain.amadeus.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HotelPrice {
    private String currency;
    private String total;
}
