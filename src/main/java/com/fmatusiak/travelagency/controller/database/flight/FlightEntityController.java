package com.fmatusiak.travelagency.controller.database.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightEntity;
import com.fmatusiak.travelagency.service.entity.flight.FlightEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/flight")
public class FlightEntityController {

    @Autowired
    private FlightEntityService flightEntityService;

    @PostMapping(value = "addFlight")
    public FlightEntity addFlight(@RequestBody FlightEntity flightEntity) {
        return flightEntityService.addFlightEntity(flightEntity);
    }

    @GetMapping(value = "getFlight/{id}")
    public FlightEntity getFlightById(@PathVariable Long id) {
        return flightEntityService.getFlightEntityById(id);
    }

    @DeleteMapping(value = "deleteFlight/{id}")
    public void deleteFlightById(@PathVariable Long id) {
        flightEntityService.deleteFlightEntityById(id);
    }

}
