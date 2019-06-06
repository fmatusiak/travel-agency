package com.fmatusiak.travelagency.client.amadeus;

import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelOffer;
import com.fmatusiak.travelagency.domain.amadeus.hotel.HotelPersonalize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmadeusHotelClient {

    @Autowired
    private AmadeusClient amadeusClient;

    public HotelOffer[] getListHotelOfferByCityCode(HotelPersonalize hotelPersonalize) throws ResponseException {
        return amadeusClient.getBuildAmadeus().shopping.hotelOffers.get(Params
                .with("cityCode", hotelPersonalize.getCityCode())
                .and("checkInDate", hotelPersonalize.getCheckInDate())
                .and("checkOutDate", hotelPersonalize.getCheckOutDate())
                .and("roomQuantity", hotelPersonalize.getRoomQuantity())
                .and("adults", hotelPersonalize.getAdults()));
    }

    public HotelOffer getHotelOfferByHotelId(String hotelId) throws ResponseException {
        return amadeusClient.getBuildAmadeus()
                .shopping.hotelOffersByHotel.get(Params.with("hotelId", hotelId));
    }

}
