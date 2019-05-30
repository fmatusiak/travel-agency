package com.fmatusiak.travelagency.domain.amadeus.enums;

import lombok.Getter;

@Getter
public enum TravelClass {
    ECONOMY("ECONOMY"),
    PREMIUM_ECONOMY("PREMIUM_ECONOMY"),
    BUSINESS("BUSINESS"),
    FIRST("FIRST");

    String name;

    TravelClass(String name) {
        this.name = name;
    }

}

