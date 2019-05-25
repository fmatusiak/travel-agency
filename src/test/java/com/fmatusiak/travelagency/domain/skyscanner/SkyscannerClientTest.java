package com.fmatusiak.travelagency.domain.skyscanner;

import org.junit.Test;
import org.springframework.util.Assert;

public class SkyscannerClientTest {

    @Test
    public void testFlightsWithoutDepartureDates() {
        //when
        FlightSearch flightSearch = FlightSearch.builder()
                .arrivalCity("STOC-sky")
                .departureCity("WARS-sky")
                .departureDates("2019-10-10")
                .build();

        SkyscannerClient skyscannerClient = new SkyscannerClient();

        //when
        Quotes quotes = skyscannerClient.getFlightsWithoutDepartureDates(flightSearch);

        //then
        Assert.notNull(quotes);

    }

    /*@Test
    public void testFlightsWithDepartureDates() {
    }*/
}