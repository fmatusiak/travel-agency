package com.fmatusiak.travelagency.service.amadeus;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelOffer;
import com.fmatusiak.travelagency.domain.amadeus.hotel.personalize.HotelPersonalizeBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelScoreServiceTest {

    @Autowired
    private HotelService hotelService;

    @Test
    public void testHotelOfferListByCityCode() throws ResponseException {
        //given
        HotelOffer[] hotelOffers = hotelService.getHotelOfferListByCityCode(new HotelPersonalizeBuilder()
                .setAdults(1)
                .setCheckInDate(LocalDate.now().toString())
                .setCheckOutDate(LocalDate.now().plusDays(7).toString())
                .setCityCode("LON")
                .createHotelPersonalize());
        //when
        //then
        Assert.assertNotNull(hotelOffers);
    }

    @Test
    public void testHotelOfferByHotelId() throws ResponseException {
        //given
        HotelOffer hotel = hotelService.getHotelOfferByHotelId("RDLON315");
        //when
        //then
        Assert.assertNotNull(hotel);
    }
}