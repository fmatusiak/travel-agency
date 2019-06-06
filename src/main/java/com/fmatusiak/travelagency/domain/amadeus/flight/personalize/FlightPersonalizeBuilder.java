package com.fmatusiak.travelagency.domain.amadeus.flight.personalize;

public class FlightPersonalizeBuilder {
    private String originPlace;
    private String destinationPlace;
    private String departureDate;
    private String returnDate;
    private int adultsQuantity;
    private int childrenQuantity;
    private int seniorsQuantity;
    private String travelClass;

    public FlightPersonalizeBuilder setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
        return this;
    }

    public FlightPersonalizeBuilder setDestinationPlace(String destinationPlace) {
        this.destinationPlace = destinationPlace;
        return this;
    }

    public FlightPersonalizeBuilder setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public FlightPersonalizeBuilder setReturnDate(String returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public FlightPersonalizeBuilder setAdultsQuantity(int adultsQuantity) {
        this.adultsQuantity = adultsQuantity;
        return this;
    }

    public FlightPersonalizeBuilder setChildrenQuantity(int childrenQuantity) {
        this.childrenQuantity = childrenQuantity;
        return this;
    }

    public FlightPersonalizeBuilder setSeniorsQuantity(int seniorsQuantity) {
        this.seniorsQuantity = seniorsQuantity;
        return this;
    }

    public FlightPersonalizeBuilder setTravelClass(String travelClass) {
        this.travelClass = travelClass;
        return this;
    }

    public FlightPersonalize createFlightPersonalize() {
        if (adultsQuantity <= 0) {
            this.adultsQuantity = 1;
        }
        return new FlightPersonalize(originPlace, destinationPlace, departureDate, returnDate
                , adultsQuantity, childrenQuantity, seniorsQuantity, travelClass);
    }
}