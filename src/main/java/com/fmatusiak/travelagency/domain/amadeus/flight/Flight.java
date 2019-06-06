package com.fmatusiak.travelagency.domain.amadeus.flight;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Flight {
    private FlightDeparture departure;
    private FlightArrival arrival;
    private FlightPriceDetailPerAdult pricingDetailPerAdult;
    private FlightPrice price;
}
