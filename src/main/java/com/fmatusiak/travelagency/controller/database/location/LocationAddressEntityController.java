package com.fmatusiak.travelagency.controller.database.location;

import com.fmatusiak.travelagency.domain.entity.location.LocationAddressEntity;
import com.fmatusiak.travelagency.service.entity.location.LocationAddressEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/location")
public class LocationAddressEntityController {

    @Autowired
    private LocationAddressEntityService locationAddressEntityService;

    @PostMapping(value = "addLocationAddress")
    public LocationAddressEntity addLocationAddress(@RequestBody LocationAddressEntity locationAddressEntity) {
        return locationAddressEntityService.addLocationAddress(locationAddressEntity);
    }

    @GetMapping(value = "getLocationAddress/{id}")
    public Optional<LocationAddressEntity> getLocationAddressById(@PathVariable long id) {
        return locationAddressEntityService.getLocationAddressById(id);
    }

    @DeleteMapping(value = "deleteLocationAddress/{id}")
    public void deleteLocationAddressById(@PathVariable long id) {
        locationAddressEntityService.deleteLocationAddressById(id);
    }

}
