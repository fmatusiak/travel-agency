package com.fmatusiak.travelagency.service.entity.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightPriceDetailPerAdultEntity;
import com.fmatusiak.travelagency.repository.flight.FlightPriceDetailPerAdultEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class FlightPriceDetailPerAdultEntityService {

    @Autowired
    private FlightPriceDetailPerAdultEntityRepository flightPriceDetailPerAdultEntityRepository;

    public FlightPriceDetailPerAdultEntity addFlightPriceDetailPerAdult(FlightPriceDetailPerAdultEntity flightPriceDetailPerAdultEntity) {
        return flightPriceDetailPerAdultEntityRepository.save(flightPriceDetailPerAdultEntity);
    }

    public Optional<FlightPriceDetailPerAdultEntity> getFlightPriceDetailPerAdultyById(long id) {
        return flightPriceDetailPerAdultEntityRepository.findById(id);
    }

    public void deleteFlightPriceDetailPerAdult(long id) {
        flightPriceDetailPerAdultEntityRepository.deleteById(id);
    }
}
