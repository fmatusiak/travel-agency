package com.fmatusiak.travelagency.mapper.amadeus.flight;

import com.amadeus.resources.FlightOffer;
import com.fmatusiak.travelagency.domain.amadeus.flight.*;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class FlightOfferMapper {

    public List<Flight> FlightOfferAmadeusTabToFlightOfferListMapper(final FlightOffer[] flightOffers) {
        List<Flight> flightList = new ArrayList<>();
        for (FlightOffer flightOffer : flightOffers) {
            for (FlightOffer.OfferItem offerItem : flightOffer.getOfferItems()) {
                for (FlightOffer.Service service : offerItem.getServices()) {
                    for (FlightOffer.Segment segment : service.getSegments()) {
                        Flight offer = new FlightBuilder().setDeparture(
                                new FlightDeparture(
                                segment.getFlightSegment().getDeparture().getIataCode()
                                        , segment.getFlightSegment().getDeparture().getAt())).setArrival(
                                new FlightArrival(
                                segment.getFlightSegment().getArrival().getIataCode()
                                        , segment.getFlightSegment().getArrival().getIataCode())).setPricingDetailPerAdult(
                                new FlightPriceDetailPerAdult(
                                        segment.getPricingDetailPerAdult().getTravelClass()
                                        , segment.getPricingDetailPerAdult().getAvailability())).setPrice(
                                new FlightPrice(offerItem.getPrice().getTotal())).createFlight();
                        flightList.add(offer);
                    }
                }
            }
        }
        return flightList;
    }

}



