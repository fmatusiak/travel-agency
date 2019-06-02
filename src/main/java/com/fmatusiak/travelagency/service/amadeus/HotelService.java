package com.fmatusiak.travelagency.service.amadeus;

import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelOffer;
import com.fmatusiak.travelagency.domain.amadeus.AmadeusClient;
import org.springframework.beans.factory.annotation.Autowired;

public class HotelService {

    @Autowired
    private AmadeusClient amadeusClient;

    public HotelOffer[] getListHotelOfferByCityCode(String cityCode) throws ResponseException {
        return amadeusClient.getBuildAmadeus()
                .shopping.hotelOffers
                .get(Params.with("cityCode", cityCode));
    }

    public HotelOffer getHotelOfferByHotelId(String hotelId) throws ResponseException {
        return amadeusClient.getBuildAmadeus()
                .shopping.hotelOffersByHotel
                .get(Params.with("hotelId", hotelId));
    }

}
