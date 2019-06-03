package com.fmatusiak.travelagency.domain.amadeus.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private Data data;
    private Address address;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data {
        private String name;
        private String detailedName;
        private String iataCode;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Address {
        private String cityName;
        private String cityCode;
        private String countryName;
    }

}
