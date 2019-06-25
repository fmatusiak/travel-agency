package com.fmatusiak.travelagency.client.accuweather;

import com.fmatusiak.travelagency.domain.accuweather.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AccuweatherCityClientTest {

    @Autowired
    private AccuweatherCityClient accuweatherCityClient;

    @Test
    public void testGetTopCities() {
        //given
        List<City> cityList = accuweatherCityClient.getTopCities(4);

        //when & then
        assertNotNull(cityList);
    }
}