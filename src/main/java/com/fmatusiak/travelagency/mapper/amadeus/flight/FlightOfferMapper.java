package com.fmatusiak.travelagency.mapper.amadeus.flight;

import com.fmatusiak.travelagency.domain.amadeus.flight.FlightOffer;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Getter
@Component
public class FlightOfferMapper {

    public List<FlightOffer> FlightOfferAmadeusTabToFlightOfferListMapper(com.amadeus.resources.FlightOffer[] flightOfferTab) {
        List<FlightOffer> flightOfferList = new ArrayList<>();
        for (com.amadeus.resources.FlightOffer flightOffer : flightOfferTab) {
            for (com.amadeus.resources.FlightOffer.OfferItem offerItem : flightOffer.getOfferItems()) {
                for (com.amadeus.resources.FlightOffer.Service service : offerItem.getServices()) {
                    for (com.amadeus.resources.FlightOffer.Segment segment : service.getSegments()) {
                        FlightOffer offer = new FlightOffer(
                                new FlightOffer.Departure(
                                        segment.getFlightSegment().getDeparture().getIataCode()
                                        , segment.getFlightSegment().getDeparture().getAt())
                                , new FlightOffer.Arrival(
                                segment.getFlightSegment().getArrival().getIataCode()
                                , segment.getFlightSegment().getArrival().getIataCode()),
                                new FlightOffer.PricingDetailPerAdult(segment.getPricingDetailPerAdult().getTravelClass()
                                        , segment.getPricingDetailPerAdult().getAvailability()),
                                new FlightOffer.Price(offerItem.getPrice().getTotal()));
                        flightOfferList.add(offer);
                    }
                }
            }
        }
        return flightOfferList;
    }
}


