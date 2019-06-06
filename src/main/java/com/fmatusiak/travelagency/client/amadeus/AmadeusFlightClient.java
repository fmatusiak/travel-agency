package com.fmatusiak.travelagency.client.amadeus;

import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import com.fmatusiak.travelagency.domain.amadeus.enums.TravelClass;
import com.fmatusiak.travelagency.domain.amadeus.flight.personalize.FlightPersonalize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AmadeusFlightClient {

    @Autowired
    private AmadeusClient amadeusClient;

    public List<TravelClass> getTravelClass() {
        List<TravelClass> travelClassList = new ArrayList<>();
        travelClassList.add(TravelClass.BUSINESS);
        travelClassList.add(TravelClass.ECONOMY);
        travelClassList.add(TravelClass.FIRST);
        travelClassList.add(TravelClass.PREMIUM_ECONOMY);
        return travelClassList;
    }

    public FlightOffer[] findFlightsByDate(FlightPersonalize flightPersonalize) throws ResponseException {
        return amadeusClient.getBuildAmadeus().shopping.flightOffers.get(Params
                .with("origin", flightPersonalize.getOriginPlace())
                .and("destination", flightPersonalize.getDestinationPlace())
                .and("departureDate", flightPersonalize.getDepartureDate())
                .and("adults", flightPersonalize.getAdultsQuantity())
                .and("children", flightPersonalize.getChildrenQuantity())
                .and("seniors", flightPersonalize.getSeniorsQuantity())
                .and("travelClass", flightPersonalize.getTravelClass()));
    }

}
