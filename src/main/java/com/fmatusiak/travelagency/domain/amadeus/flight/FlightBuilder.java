package com.fmatusiak.travelagency.domain.amadeus.flight;

public class FlightBuilder {
    private FlightDeparture departure;
    private FlightArrival arrival;
    private FlightPriceDetailPerAdult pricingDetailPerAdult;
    private FlightPrice price;

    public FlightBuilder setDeparture(FlightDeparture departure) {
        this.departure = departure;
        return this;
    }

    public FlightBuilder setArrival(FlightArrival arrival) {
        this.arrival = arrival;
        return this;
    }

    public FlightBuilder setPricingDetailPerAdult(FlightPriceDetailPerAdult pricingDetailPerAdult) {
        this.pricingDetailPerAdult = pricingDetailPerAdult;
        return this;
    }

    public FlightBuilder setPrice(FlightPrice price) {
        this.price = price;
        return this;
    }

    public Flight createFlight() {
        return new Flight(departure, arrival, pricingDetailPerAdult, price);
    }
}