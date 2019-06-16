package com.fmatusiak.travelagency.service.amadeus;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import com.fmatusiak.travelagency.domain.amadeus.enums.TravelClass;
import com.fmatusiak.travelagency.domain.amadeus.flight.personalize.FlightPersonalizeBuilder;
import com.fmatusiak.travelagency.service.entity.flight.FlightService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightServiceTest {

    @Autowired
    private FlightService flightService;

    @Test
    public void testFindFlightsByDate() throws ResponseException {
        //Given
        String returnDate = LocalDate.now().plusDays(3).toString();
        String departureDate = LocalDate.now().toString();

        FlightOffer[] flightOffers = flightService.findFlightsByDate(
                new FlightPersonalizeBuilder()
                        .setDestinationPlace("LON")
                        .setOriginPlace("MIL")
                        .setChildrenQuantity(1)
                        .setSeniorsQuantity(1)
                        .setAdultsQuantity(1)
                        .setTravelClass(TravelClass.ECONOMY.getName())
                        .setReturnDate(returnDate)
                        .setDepartureDate(departureDate)
                        .createFlightPersonalize());
        //When
        //Then
        Assert.assertNotNull(flightOffers);
    }
}