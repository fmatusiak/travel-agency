package com.fmatusiak.travelagency.controller.database.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightPriceEntity;
import com.fmatusiak.travelagency.service.entity.flight.FlightPriceEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/flightPrice")
public class FlightPriceEntityController {

    @Autowired
    private FlightPriceEntityService flightPriceEntityService;

    @PostMapping(name = "/addFlightPrice")
    public FlightPriceEntity addFlightPrice(@RequestBody FlightPriceEntity flightPriceEntity) {
        return flightPriceEntityService.addFlightPrice(flightPriceEntity);
    }

    @GetMapping(name = "/getFlightPrice/{id}")
    public Optional<FlightPriceEntity> getFlightPriceById(@PathVariable long id) {
        return flightPriceEntityService.getFlightPriceById(id);
    }

    @DeleteMapping(name = "/deleteFlightPrice/{id}")
    public void deleteFlightById(@PathVariable long id) {
        flightPriceEntityService.getFlightPriceById(id);
    }
}
