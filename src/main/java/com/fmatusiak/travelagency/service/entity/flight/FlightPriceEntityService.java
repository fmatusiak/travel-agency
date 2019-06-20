package com.fmatusiak.travelagency.service.entity.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightPriceEntity;
import com.fmatusiak.travelagency.repository.flight.FlightPriceEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class FlightPriceEntityService {

    @Autowired
    private FlightPriceEntityRepository flightPriceEntityRepository;

    public FlightPriceEntity addFlightPrice(FlightPriceEntity flightPriceEntity) {
        return flightPriceEntityRepository.save(flightPriceEntity);
    }

    public FlightPriceEntity getFlightPriceById(long id) {
        return flightPriceEntityRepository.findById(id).orElse(null);
    }

    public void deleteFlightPriceEntityById(long id) {
        flightPriceEntityRepository.deleteById(id);
    }
}
