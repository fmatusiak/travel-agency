package com.fmatusiak.travelagency.controller.database.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightPriceDetailPerAdultEntity;
import com.fmatusiak.travelagency.service.entity.flight.FlightPriceDetailPerAdultEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/flightPriceDetailPerAdult")
public class FlightPriceDetailPerAdultEntityController {

    @Autowired
    private FlightPriceDetailPerAdultEntityService flightPriceDetailPerAdultEntityService;

    @PostMapping(value = "/add")
    public FlightPriceDetailPerAdultEntity addFlightPriceDetailPerAdult(
            @RequestBody FlightPriceDetailPerAdultEntity flightPriceDetailPerAdultEntity) {
        return flightPriceDetailPerAdultEntityService.addFlightPriceDetailPerAdult(flightPriceDetailPerAdultEntity);
    }

    @GetMapping(value = "/getFlightPriceDetailPerAdulty/{id}")
    public Optional<FlightPriceDetailPerAdultEntity> getFlightPricedetailPerAdultById(@PathVariable long id) {
        return flightPriceDetailPerAdultEntityService.getFlightPriceDetailPerAdultyById(id);
    }

    @DeleteMapping(value = "/deleteFlightPriceDetailPerAdulty/{id}")
    public void deleteFlightPricedetailPerAdultById(@PathVariable long id) {
        flightPriceDetailPerAdultEntityService.deleteFlightPriceDetailPerAdult(id);
    }

}
