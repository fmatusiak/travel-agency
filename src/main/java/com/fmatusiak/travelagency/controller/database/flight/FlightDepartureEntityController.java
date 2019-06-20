package com.fmatusiak.travelagency.controller.database.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightDepartureEntity;
import com.fmatusiak.travelagency.service.entity.flight.FlightDepartureEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/flight")
public class FlightDepartureEntityController {

    @Autowired
    private FlightDepartureEntityService flightDepartureEntityService;

    @PostMapping(value = "addFlightDeparture")
    public FlightDepartureEntity addflightDeparture(@RequestBody FlightDepartureEntity flightDepartureEntity) {
        return flightDepartureEntityService.addFlightDeparture(flightDepartureEntity);
    }

    @GetMapping(value = "getFlightDeparture/{id}")
    public FlightDepartureEntity getflightDepartureById(@PathVariable long id) {
        return flightDepartureEntityService.getFlightDepartureById(id);
    }

    @DeleteMapping(value = "deleteFlightDeparture/{id}")
    public void deleteflightDepartureById(@PathVariable long id) {
        flightDepartureEntityService.deleteFlightDepartureById(id);
    }
}