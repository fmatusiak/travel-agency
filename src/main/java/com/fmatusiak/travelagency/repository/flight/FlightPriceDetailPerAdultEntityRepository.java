package com.fmatusiak.travelagency.repository.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightPriceDetailPerAdultEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FlightPriceDetailPerAdultEntityRepository extends CrudRepository<FlightPriceDetailPerAdultEntity, Long> {

    @Override
    <S extends FlightPriceDetailPerAdultEntity> S save(S entity);

    @Override
    Optional<FlightPriceDetailPerAdultEntity> findById(Long id);

    @Override
    void deleteById(Long id);
}
