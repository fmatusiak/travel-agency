package com.fmatusiak.travelagency.controller.database.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightArrivalEntity;
import com.fmatusiak.travelagency.service.entity.flight.FlightArrivalEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/flight")
public class FlightArrivalEntityController {

    @Autowired
    private FlightArrivalEntityService flightArrivalEntityService;

    @PostMapping(value = "addFlightArrival")
    public FlightArrivalEntity addflightArrival(@RequestBody FlightArrivalEntity flightArrivalEntity) {
        return flightArrivalEntityService.addFlightArrival(flightArrivalEntity);
    }

    @GetMapping(value = "getFlightArrival/{id}")
    public FlightArrivalEntity getFlightArrivalById(@PathVariable Long id) {
        return flightArrivalEntityService.getFlightArrivalById(id);
    }

    @DeleteMapping(value = "deleteFlightArrival/{id}")
    public void deleteFlightArrivalById(@PathVariable Long id) {
        flightArrivalEntityService.deleteFlightArrivalById(id);
    }

}
