package com.fmatusiak.travelagency.controller.database.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightArrivalEntity;
import com.fmatusiak.travelagency.service.entity.flight.FlightArrivalEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/flightArrival")
public class FlightArrivalEntityController {

    private FlightArrivalEntityService flightArrivalEntityService;

    @PostMapping(value = "/addFlightArrival")
    public FlightArrivalEntity addflightArrival(@RequestBody FlightArrivalEntity flightArrivalEntity) {
        return flightArrivalEntityService.addFlightArrival(flightArrivalEntity);
    }

    @GetMapping(value = "/getFlightArrival/{id}")
    public Optional<FlightArrivalEntity> getFlightArrivalById(@PathVariable long id) {
        return flightArrivalEntityService.getFlightArrivalById(id);
    }

    @DeleteMapping(value = "/deleteFlightArrival/{id}")
    public void deleteFlightArrivalById(@PathVariable long id) {
        flightArrivalEntityService.deleteFlightArrivalById(id);
    }

}
