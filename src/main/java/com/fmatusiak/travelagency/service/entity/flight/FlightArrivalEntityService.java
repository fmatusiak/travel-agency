package com.fmatusiak.travelagency.service.entity.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightArrivalEntity;
import com.fmatusiak.travelagency.repository.flight.FlightArrivalEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class FlightArrivalEntityService {

    @Autowired
    private FlightArrivalEntityRepository flightArrivalEntityRepository;

    public FlightArrivalEntity addFlightArrival(FlightArrivalEntity flightArrivalEntity) {
        return flightArrivalEntityRepository.save(flightArrivalEntity);
    }

    public FlightArrivalEntity getFlightArrivalById(Long id) {
        return flightArrivalEntityRepository.findById(id).orElse(null);
    }

    public void deleteFlightArrivalById(Long id) {
        flightArrivalEntityRepository.deleteById(id);
    }

}
