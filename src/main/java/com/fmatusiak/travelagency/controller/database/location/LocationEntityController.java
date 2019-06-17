package com.fmatusiak.travelagency.controller.database.location;

import com.fmatusiak.travelagency.domain.entity.location.LocationEntity;
import com.fmatusiak.travelagency.service.entity.location.LocationEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/locationEntity")
public class LocationEntityController {

    @Autowired
    private LocationEntityService locationEntityService;

    @PostMapping(value = "addLocation")
    public LocationEntity addLocation(@RequestBody LocationEntity locationEntity) {
        return locationEntityService.addLocation(locationEntity);
    }

    @GetMapping(value = "getLocation/{id}")
    public Optional<LocationEntity> getLocationById(@PathVariable long id) {
        return locationEntityService.getLocationById(id);
    }

    @DeleteMapping(value = "deleteLocation/{id}")
    public void deleteLocationById(@PathVariable long id) {
        locationEntityService.deleteLocationById(id);
    }
}
