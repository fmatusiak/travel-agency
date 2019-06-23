package com.fmatusiak.travelagency.controller.database.location;

import com.fmatusiak.travelagency.domain.entity.location.LocationDataEntity;
import com.fmatusiak.travelagency.service.entity.location.LocationDataEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/location")
public class LocationDataEntityController {

    @Autowired
    private LocationDataEntityService locationDataEntityService;

    @PostMapping(value = "addLocationData")
    public LocationDataEntity addLocationData(@RequestBody LocationDataEntity locationDataEntity) {
        return locationDataEntityService.addLocationData(locationDataEntity);
    }

    @GetMapping(value = "getLocationData/{id}")
    public LocationDataEntity getLocationDataById(@PathVariable long id) {
        return locationDataEntityService.getLocationDataById(id);
    }

    @DeleteMapping(value = "deleteLocationData/{id}")
    public void deleteLocationDataById(@PathVariable long id) {
        locationDataEntityService.deleteLocationDataById(id);
    }

}
