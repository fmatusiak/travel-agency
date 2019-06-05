package com.fmatusiak.travelagency.domain.amadeus.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HotelRoom {
    private String category;
    private int beds;
    private String bedType;
}
