package com.fmatusiak.travelagency.service.entity.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightEntity;
import com.fmatusiak.travelagency.repository.flight.FlightEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class FlightEntityService {

    @Autowired
    private FlightEntityRepository flightEntityRepository;

    public FlightEntity addFlightEntity(FlightEntity flightEntity) {
        return flightEntityRepository.save(flightEntity);
    }

    public Optional<FlightEntity> getFlightEntityById(long id) {
        return flightEntityRepository.findById(id);
    }

    public void deleteFlightEntityById(long id) {
        flightEntityRepository.deleteById(id);
    }
}
