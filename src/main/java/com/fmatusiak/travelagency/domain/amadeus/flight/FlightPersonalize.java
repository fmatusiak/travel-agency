package com.fmatusiak.travelagency.domain.amadeus.flight;

import lombok.Getter;

@Getter
public class FlightPersonalize {

    private String originPlace;
    private String destinationPlace;
    private String departureDate;
    private String returnDate;
    private int adultsQuantity;
    private int childrenQuantity;
    private int seniorsQuantity;
    private String travelClass;


    public FlightPersonalize(String originPlace, String destinationPlace, String departureDate
            , String returnDate, int adultsQuantity, int childrenQuantity, int seniorsQuantity, String travelClass) {
        this.originPlace = originPlace;
        this.destinationPlace = destinationPlace;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.adultsQuantity = adultsQuantity;
        this.childrenQuantity = childrenQuantity;
        this.seniorsQuantity = seniorsQuantity;
        this.travelClass = travelClass;
    }
}
