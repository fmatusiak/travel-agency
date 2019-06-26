package com.fmatusiak.travelagency.controller.database.weather;

import com.fmatusiak.travelagency.domain.entity.weather.CityEntity;
import com.fmatusiak.travelagency.service.entity.weather.CityEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/city")
public class CityEntityController {

    @Autowired
    private CityEntityService cityEntityService;

    @PostMapping(value = "addCity")
    public CityEntity addCity(@RequestBody CityEntity cityEntity) {
        return cityEntityService.addCity(cityEntity);
    }

    @GetMapping(value = "getCity/{id}")
    public CityEntity getCityById(@PathVariable Long id) {
        return cityEntityService.getCityById(id);
    }

    @DeleteMapping(value = "deleteCity/{id}")
    public void deleteCityById(@PathVariable Long id) {
        cityEntityService.deleteCityById(id);
    }

}
