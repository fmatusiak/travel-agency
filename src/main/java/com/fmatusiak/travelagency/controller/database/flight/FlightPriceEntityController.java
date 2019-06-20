package com.fmatusiak.travelagency.controller.database.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightPriceEntity;
import com.fmatusiak.travelagency.service.entity.flight.FlightPriceEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/flight")
public class FlightPriceEntityController {

    @Autowired
    private FlightPriceEntityService flightPriceEntityService;

    @PostMapping(value = "addFlightPrice")
    public FlightPriceEntity addFlightPrice(@RequestBody FlightPriceEntity flightPriceEntity) {
        return flightPriceEntityService.addFlightPrice(flightPriceEntity);
    }

    @GetMapping(value = "getFlightPrice/{id}")
    public FlightPriceEntity getFlightPriceById(@PathVariable long id) {
        return flightPriceEntityService.getFlightPriceById(id);
    }

    @DeleteMapping(value = "deleteFlightPrice/{id}")
    public void deleteFlightById(@PathVariable long id) {
        flightPriceEntityService.getFlightPriceById(id);
    }
}
