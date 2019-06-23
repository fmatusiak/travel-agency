package com.fmatusiak.travelagency.controller.database.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelContactEntity;
import com.fmatusiak.travelagency.service.entity.hotel.HotelContactEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/hotel")
public class HotelContactEntityController {

    @Autowired
    private HotelContactEntityService hotelContactEntityService;

    @PostMapping(value = "addHotelContact")
    public HotelContactEntity addHotelContact(@RequestBody HotelContactEntity hotelContactEntity) {
        return hotelContactEntityService.addHotelContact(hotelContactEntity);
    }

    @GetMapping(value = "getHotelContact/{id}")
    public HotelContactEntity getHotelContactById(@PathVariable Long id) {
        return hotelContactEntityService.getHotelContactById(id);
    }

    @DeleteMapping(value = "deleteHotelContact/{id}")
    public void deleteHotelContactById(Long id) {
        hotelContactEntityService.deleteHotelContactById(id);
    }

}
