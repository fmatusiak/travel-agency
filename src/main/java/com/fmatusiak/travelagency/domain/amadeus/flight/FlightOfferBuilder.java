package com.fmatusiak.travelagency.domain.amadeus.flight;

public class FlightOfferBuilder {
    private FlightDeparture departure;
    private FlightArrival arrival;
    private FlightPriceDetailPerAdult pricingDetailPerAdult;
    private FlightPrice price;

    public FlightOfferBuilder setDeparture(FlightDeparture departure) {
        this.departure = departure;
        return this;
    }

    public FlightOfferBuilder setArrival(FlightArrival arrival) {
        this.arrival = arrival;
        return this;
    }

    public FlightOfferBuilder setPricingDetailPerAdult(FlightPriceDetailPerAdult pricingDetailPerAdult) {
        this.pricingDetailPerAdult = pricingDetailPerAdult;
        return this;
    }

    public FlightOfferBuilder setPrice(FlightPrice price) {
        this.price = price;
        return this;
    }

    public FlightOffer createFlightOffer() {
        return new FlightOffer(departure, arrival, pricingDetailPerAdult, price);
    }
}