package com.fmatusiak.travelagency.service.amadeus;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelOffer;
import com.fmatusiak.travelagency.client.amadeus.AmadeusHotelClient;
import com.fmatusiak.travelagency.domain.amadeus.hotel.personalize.HotelPersonalize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class HotelService {

    @Autowired
    private AmadeusHotelClient amadeusHotelClient;

    public com.amadeus.resources.HotelOffer[] getHotelOfferListByCityCode(HotelPersonalize hotelPersonalize) throws ResponseException {
        return amadeusHotelClient.getListHotelOfferByCityCode(hotelPersonalize);
    }

    public HotelOffer getHotelOfferByHotelId(String hotelId) throws ResponseException {
        return amadeusHotelClient.getHotelOfferByHotelId(hotelId);
    }

}
