package com.fmatusiak.travelagency.service.entity.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightArrivalEntity;
import com.fmatusiak.travelagency.repository.flight.FlightArrivalEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class FlightArrivalEntityService {

    @Autowired
    private FlightArrivalEntityRepository flightArrivalEntityRepository;

    public FlightArrivalEntity addFlightArrival(FlightArrivalEntity flightArrivalEntity) {
        return flightArrivalEntityRepository.save(flightArrivalEntity);
    }

    public Optional<FlightArrivalEntity> getFlightArrivalById(long id) {
        return flightArrivalEntityRepository.findById(id);
    }

    public void deleteFlightArrivalById(long id) {
        flightArrivalEntityRepository.deleteById(id);
    }

}
