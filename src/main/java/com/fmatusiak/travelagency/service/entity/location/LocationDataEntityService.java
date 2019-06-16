package com.fmatusiak.travelagency.service.entity.location;


import com.fmatusiak.travelagency.domain.entity.location.LocationDataEntity;
import com.fmatusiak.travelagency.repository.location.LocationDataEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class LocationDataEntityService {

    @Autowired
    private LocationDataEntityRepository locationDataEntityRepository;

    public LocationDataEntity addLocationData(LocationDataEntity locationDataEntity) {
        return locationDataEntityRepository.save(locationDataEntity);
    }

    public Optional<LocationDataEntity> getLocationDataById(long id) {
        return locationDataEntityRepository.findById(id);
    }

    public void deleteLocationDataById(long id) {
        locationDataEntityRepository.deleteById(id);
    }

}
