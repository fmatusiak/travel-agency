package com.fmatusiak.travelagency.service.entity.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightEntity;
import com.fmatusiak.travelagency.repository.flight.FlightEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class FlightEntityService {

    @Autowired
    private FlightEntityRepository flightEntityRepository;

    public FlightEntity addFlightEntity(FlightEntity flightEntity) {
        return flightEntityRepository.save(flightEntity);
    }

    public FlightEntity getFlightEntityById(long id) {
        return flightEntityRepository.findById(id).orElse(null);
    }

    public void deleteFlightEntityById(long id) {
        flightEntityRepository.deleteById(id);
    }
}
