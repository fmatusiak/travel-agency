package com.fmatusiak.travelagency.service.accuweather;

import com.fmatusiak.travelagency.domain.accuweather.City;
import com.fmatusiak.travelagency.domain.accuweather.DailyForecasts;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherServiceTest {

    @Autowired
    private WeatherService weatherService;

    @Test
    public void testWeatherByCityKey() {
        //given
        DailyForecasts dailyForecasts = weatherService.getWeatherByCityKey(274663);
        //when
        //then
        Assert.assertNotNull(dailyForecasts);
    }

    @Test
    public void testCitiesByCityName() {
        //given
        List<City> cityList = weatherService.getCitiesByCityName("WARSAW");
        //when
        //then
        Assert.assertNotNull(cityList);
    }
}