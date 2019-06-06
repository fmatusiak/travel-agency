package com.fmatusiak.travelagency.controller;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelOffer;
import com.fmatusiak.travelagency.domain.amadeus.hotel.HotelPersonalizeBuilder;
import com.fmatusiak.travelagency.service.amadeus.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping(value = "/hotelofferlist/{cityCode}/{checkInDate}/{checkOutDate}/{roomQuantity}/{adults}")
    public HotelOffer[] getHotelOfferListByCityCode(@PathVariable String cityCode, @PathVariable String checkInDate
            , @PathVariable String checkOutDate, @PathVariable int roomQuantity
            , @PathVariable int adults) throws ResponseException {
        return hotelService.getHotelOfferListByCityCode(new HotelPersonalizeBuilder()
                .setCityCode(cityCode)
                .setCheckInDate(checkInDate)
                .setCheckOutDate(checkOutDate)
                .setRoomQuantity(roomQuantity)
                .setAdults(adults)
                .createHotelPersonalize());
    }

    @GetMapping(value = "hotelofferbyhotelid/{hotelId}")
    public HotelOffer getHotelOfferByHotelId(@PathVariable String hotelId) throws ResponseException {
        return hotelService.getHotelOfferByHotelId(hotelId);
    }
}
