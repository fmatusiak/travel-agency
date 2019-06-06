package com.fmatusiak.travelagency.mapper.amadeus.hotel;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelOffer;
import com.fmatusiak.travelagency.domain.amadeus.hotel.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class HotelOfferMapper {

    public List<Hotel> hoteloffersTabToHotelList(final HotelOffer[] hotelOffers) throws ResponseException {
        ArrayList<Hotel> hotels = new ArrayList<>();
        for (HotelOffer hotelOffer : hotelOffers) {
            Hotel hotel = new HotelBuilder()
                    .setHotelAddress(new HotelAddress(hotelOffer.getHotel().getAddress().getCityName()
                            , hotelOffer.getHotel().getAddress().getCountryCode()))
                    .setHotelAmentities(new HotelAmentities(Arrays.asList(hotelOffer.getHotel().getAmenities())))
                    .setHotelContact(new HotelContact(hotelOffer.getHotel().getContact().getPhone()
                            , hotelOffer.getHotel().getContact().getFax()))
                    .setHotelProperty(new HotelProperty(
                            hotelOffer.getHotel().getHotelId()
                            , hotelOffer.getHotel().getChainCode()
                            , hotelOffer.getHotel().getName()
                            , hotelOffer.getHotel().getRating()
                            , hotelOffer.getHotel().getCityCode()))
                    .createHotel();
            hotels.add(hotel);
        }
        return hotels;
    }

}
