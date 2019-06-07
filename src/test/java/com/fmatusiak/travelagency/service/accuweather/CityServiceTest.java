package com.fmatusiak.travelagency.service.accuweather;

import com.fmatusiak.travelagency.domain.accuweather.City;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceTest {

    @Autowired
    private CityService cityService;

    @Test
    public void testTopCities() {
        //given
        List<City> cityList = cityService.getTopCities(5);
        //when
        //then
        Assert.assertNotNull(cityList);
    }
}