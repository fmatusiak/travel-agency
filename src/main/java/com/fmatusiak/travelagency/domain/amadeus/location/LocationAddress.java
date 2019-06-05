package com.fmatusiak.travelagency.domain.amadeus.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LocationAddress {
    private String cityName;
    private String cityCode;
    private String countryName;
}
