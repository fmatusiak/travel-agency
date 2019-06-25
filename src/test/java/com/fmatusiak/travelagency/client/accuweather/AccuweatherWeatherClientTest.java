package com.fmatusiak.travelagency.client.accuweather;

import com.fmatusiak.travelagency.domain.accuweather.City;
import com.fmatusiak.travelagency.domain.accuweather.DailyForecasts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccuweatherWeatherClientTest {

    @Autowired
    private AccuweatherWeatherClient accuweatherWeatherClient;

    @Test
    public void testGetWeatherByCityKey() {
        //given
        List<City> cityList = accuweatherWeatherClient.getCitiesByCityName("LON");
        //when & then
        assertNotNull(cityList);
    }

    @Test
    public void testGetCitiesByCityName() {
        //given
        DailyForecasts dailyForecasts = accuweatherWeatherClient.getWeatherByCityKey(274663);
        //when & then
        assertNotNull(dailyForecasts);
    }

}