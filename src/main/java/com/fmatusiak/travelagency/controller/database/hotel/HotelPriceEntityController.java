package com.fmatusiak.travelagency.controller.database.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelPriceEntity;
import com.fmatusiak.travelagency.service.entity.hotel.HotelPriceEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/hotel")
public class HotelPriceEntityController {

    @Autowired
    private HotelPriceEntityService hotelPriceEntityService;

    @PostMapping(value = "addHotelPrice")
    public HotelPriceEntity addHotelPrice(@RequestBody HotelPriceEntity hotelPriceEntity) {
        return hotelPriceEntityService.addHotelPrice(hotelPriceEntity);
    }

    @GetMapping(value = "getHotelPrice/{id}")
    public HotelPriceEntity getHotelPriceById(@PathVariable Long id) {
        return hotelPriceEntityService.getHotelPriceById(id);
    }

    @DeleteMapping(value = "deleteHotelPrice/{id}")
    public void deleteHotelPriceById(@PathVariable Long id) {
        hotelPriceEntityService.deleteHotelPriceById(id);
    }
}
