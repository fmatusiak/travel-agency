package com.fmatusiak.travelagency.domain.amadeus;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.FlightOffer;
import com.amadeus.resources.HotelOffer;
import com.amadeus.resources.Location;
import com.fmatusiak.travelagency.config.amadeus.AmadeusConfig;
import com.fmatusiak.travelagency.domain.amadeus.enums.TravelClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class AmadeusClient {

    private final static Logger LOGGER = Logger.getLogger(AmadeusClient.class.getName());

    @Autowired
    private AmadeusConfig amadeusConfig;

    public Amadeus getBuildAmadeus() {
        return Amadeus
                .builder(amadeusConfig.getKeyAmadeus(), amadeusConfig.getSecretAmadeus())
                .setLogger(LOGGER)
                .build();
    }

    public Location[] getFindCityListSearchByKeyword(String keyword) throws ResponseException {
        return getBuildAmadeus()
                .referenceData.locations
                .get(Params.with("keyword", keyword).and("subType", Locations.CITY));
    }

    public Location[] getFindAirportListSearchByKeyword(String keyword) throws ResponseException {
        return getBuildAmadeus()
                .referenceData.locations
                .get(Params.with("keyword", keyword).and("subType", Locations.AIRPORT));
    }

    public HotelOffer[] getListHotelOfferByCityCode(String cityCode) throws ResponseException {
        return getBuildAmadeus()
                .shopping.hotelOffers
                .get(Params.with("cityCode", cityCode));
    }

    public HotelOffer getHotelOfferByHotelId(String hotelId) throws ResponseException {
        return getBuildAmadeus()
                .shopping.hotelOffersByHotel
                .get(Params.with("hotelId", hotelId));
    }

    public List<TravelClass> getTravelClass() {
        List<TravelClass> travelClassList = new ArrayList<>();
        travelClassList.add(TravelClass.BUSINESS);
        travelClassList.add(TravelClass.ECONOMY);
        travelClassList.add(TravelClass.FIRST);
        travelClassList.add(TravelClass.PREMIUM_ECONOMY);
        return travelClassList;
    }

    public FlightOffer[] findFlightsByDate(String originPlace, String destinationPlace, String date) throws ResponseException {
        return getBuildAmadeus().shopping.flightOffers.get(Params
                .with("origin", originPlace)
                .and("destination", destinationPlace)
                .and("departureDate", date));
    }

}
