package com.fmatusiak.travelagency.service.entity.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightPriceEntity;
import com.fmatusiak.travelagency.repository.flight.FlightPriceEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class FlightPriceEntityService {

    @Autowired
    private FlightPriceEntityRepository flightPriceEntityRepository;

    public FlightPriceEntity addFlightPrice(FlightPriceEntity flightPriceEntity) {
        return flightPriceEntityRepository.save(flightPriceEntity);
    }

    public Optional<FlightPriceEntity> getFlightPriceById(long id) {
        return flightPriceEntityRepository.findById(id);
    }

    public void deleteFlightPriceEntityById(long id) {
        flightPriceEntityRepository.deleteById(id);
    }
}
