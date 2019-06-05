package com.fmatusiak.travelagency.domain.amadeus.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LocationData {
    private String name;
    private String detailedName;
    private String iataCode;
}
