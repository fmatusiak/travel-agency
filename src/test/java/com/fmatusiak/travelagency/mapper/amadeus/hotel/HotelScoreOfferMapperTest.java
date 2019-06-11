package com.fmatusiak.travelagency.mapper.amadeus.hotel;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelOffer;
import com.fmatusiak.travelagency.domain.amadeus.hotel.HotelScore;
import com.fmatusiak.travelagency.domain.amadeus.hotel.personalize.HotelPersonalizeBuilder;
import com.fmatusiak.travelagency.service.amadeus.HotelService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelScoreOfferMapperTest {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelOfferMapper hotelOfferMapper;

    @Test
    public void testhotelOffersTabToHotelList() throws ResponseException {
        //given
        HotelOffer[] hotelOffers = hotelService.getHotelOfferListByCityCode(new HotelPersonalizeBuilder()
                .setAdults(1)
                .setCheckInDate(LocalDate.now().toString())
                .setCheckOutDate(LocalDate.now().plusDays(7).toString())
                .setCityCode("LON")
                .createHotelPersonalize());
        //when
        List<HotelScore> hotelScoreListMapper = hotelOfferMapper.hoteloffersTabToHotelList(hotelOffers);
        //then
        Assert.assertNotNull(hotelScoreListMapper);
    }
}