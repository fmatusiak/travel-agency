package com.fmatusiak.travelagency.service.entity.location;

import com.fmatusiak.travelagency.domain.entity.location.LocationEntity;
import com.fmatusiak.travelagency.repository.location.LocationEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class LocationEntityService {

    @Autowired
    private LocationEntityRepository locationEntityRepository;

    public LocationEntity addLocation(LocationEntity locationEntity) {
        return locationEntityRepository.save(locationEntity);
    }

    public LocationEntity getLocationById(long id) {
        return locationEntityRepository.findById(id).orElse(null);
    }

    public void deleteLocationById(long id) {
        locationEntityRepository.deleteById(id);
    }

}
