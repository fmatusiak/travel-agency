package com.fmatusiak.travelagency.controller.amadeus;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelOffer;
import com.fmatusiak.travelagency.domain.amadeus.hotel.HotelScore;
import com.fmatusiak.travelagency.domain.amadeus.hotel.personalize.HotelPersonalizeBuilder;
import com.fmatusiak.travelagency.mapper.amadeus.hotel.HotelOfferMapper;
import com.fmatusiak.travelagency.service.amadeus.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelOfferMapper hotelOfferMapper;

    @GetMapping(value = "/hotelofferlist/{cityCode}/{checkInDate}/{checkOutDate}/{roomQuantity}/{adults}")
    public List<HotelScore> getHotelOfferList(
            @PathVariable String cityCode, @PathVariable String checkInDate
            , @PathVariable String checkOutDate, @PathVariable int roomQuantity
            , @PathVariable int adults) throws ResponseException {
        return hotelOfferMapper.hoteloffersTabToHotelList(
                hotelService.getHotelOfferListByCityCode(new HotelPersonalizeBuilder()
                .setCityCode(cityCode)
                .setCheckInDate(checkInDate)
                .setCheckOutDate(checkOutDate)
                .setRoomQuantity(roomQuantity)
                .setAdults(adults)
                        .createHotelPersonalize()));
    }

    @GetMapping(value = "hotelofferbyhotelid/{hotelId}")
    public HotelOffer getHotelOfferByHotelId(@PathVariable String hotelId) throws ResponseException {
        return hotelService.getHotelOfferByHotelId(hotelId);
    }
}
