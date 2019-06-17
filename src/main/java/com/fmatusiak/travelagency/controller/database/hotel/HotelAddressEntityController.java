package com.fmatusiak.travelagency.controller.database.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelAddressEntity;
import com.fmatusiak.travelagency.service.entity.hotel.HotelAddressEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/hotelAddress")
public class HotelAddressEntityController {

    @Autowired
    private HotelAddressEntityService hotelAddressEntityService;

    @PostMapping(value = "addHotelAddress")
    public HotelAddressEntity addHotelAddress(@RequestBody HotelAddressEntity hotelAddressEntity) {
        return hotelAddressEntityService.addHotelAddress(hotelAddressEntity);
    }

    @GetMapping(value = "getHotelAddress/{id}")
    public Optional<HotelAddressEntity> getHotelAddressById(@PathVariable long id) {
        return hotelAddressEntityService.getHotelAddressById(id);
    }

    @DeleteMapping(value = "deleteHotelAddress/{id}")
    public void deleteHotelAddressById(@PathVariable long id) {
        hotelAddressEntityService.deleteHotelAddressById(id);
    }


}
