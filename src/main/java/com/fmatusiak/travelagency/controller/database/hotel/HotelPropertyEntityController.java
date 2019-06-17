package com.fmatusiak.travelagency.controller.database.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelPropertyEntity;
import com.fmatusiak.travelagency.service.entity.hotel.HotelPropertyEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/hotelProperty")
public class HotelPropertyEntityController {

    @Autowired
    private HotelPropertyEntityService hotelPropertyEntityService;

    @PostMapping(value = "addHotelProperty")
    public HotelPropertyEntity addHotelProperty(@RequestBody HotelPropertyEntity hotelPropertyEntity) {
        return hotelPropertyEntityService.addHotelProperty(hotelPropertyEntity);
    }

    @GetMapping(value = "getHotelProperty/{id}")
    public Optional<HotelPropertyEntity> getHotelPropertyById(@PathVariable long id) {
        return hotelPropertyEntityService.getHotelPropertyById(id);
    }

    @DeleteMapping(value = "deleteHotelProperty/{id}")
    public void deleteHotelPropertyById(@PathVariable long id) {
        hotelPropertyEntityService.deleteHotelPropertyById(id);
    }
}
