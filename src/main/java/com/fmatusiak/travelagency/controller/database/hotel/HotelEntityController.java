package com.fmatusiak.travelagency.controller.database.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelEntity;
import com.fmatusiak.travelagency.service.entity.hotel.HotelEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/hotel")
public class HotelEntityController {

    @Autowired
    private HotelEntityService hotelEntityService;

    @PostMapping(value = "addHotel")
    public HotelEntity addHotel(@RequestBody HotelEntity hotelEntity) {
        return hotelEntityService.addHotel(hotelEntity);
    }

    @GetMapping(value = "getHotel/{id}")
    public HotelEntity getHotelById(@PathVariable Long id) {
        return hotelEntityService.getHotelById(id);
    }

    @DeleteMapping(value = "deleteHotel/{id}")
    public void deleteHotelById(@PathVariable Long id) {
        hotelEntityService.deleteHotelById(id);
    }
}
