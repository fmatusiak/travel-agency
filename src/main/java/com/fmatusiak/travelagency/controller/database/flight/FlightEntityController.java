package com.fmatusiak.travelagency.controller.database.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightEntity;
import com.fmatusiak.travelagency.service.entity.flight.FlightEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/flight")
public class FlightEntityController {

    @Autowired
    private FlightEntityService flightEntityService;

    @PostMapping(name = "/addFlight")
    public FlightEntity addFlight(@RequestBody FlightEntity flightEntity) {
        return flightEntityService.addFlightEntity(flightEntity);
    }

    @GetMapping(name = "/getFlight/{id}")
    public Optional<FlightEntity> getFlightById(@PathVariable long id) {
        return flightEntityService.getFlightEntityById(id);
    }

    @DeleteMapping(name = "/deleteFlight/{id}")
    public void deleteFlightById(@PathVariable long id) {
        flightEntityService.deleteFlightEntityById(id);
    }

}
