package com.fmatusiak.travelagency.controller.database.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelPriceEntity;
import com.fmatusiak.travelagency.service.entity.hotel.HotelPriceEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/hotelPrice")
public class HotelPriceEntityController {

    @Autowired
    private HotelPriceEntityService hotelPriceEntityService;

    @PostMapping(value = "addHotelPrice")
    public HotelPriceEntity addHotelPrice(@RequestBody HotelPriceEntity hotelPriceEntity) {
        return hotelPriceEntityService.addHotelPrice(hotelPriceEntity);
    }

    @GetMapping(value = "getHotelPrice/{id}")
    public Optional<HotelPriceEntity> getHotelPriceById(@PathVariable long id) {
        return hotelPriceEntityService.getHotelPriceById(id);
    }

    @DeleteMapping(value = "deleteHotelPrice/{id}")
    public void deleteHotelPriceById(@PathVariable long id) {
        hotelPriceEntityService.deleteHotelPriceById(id);
    }
}
