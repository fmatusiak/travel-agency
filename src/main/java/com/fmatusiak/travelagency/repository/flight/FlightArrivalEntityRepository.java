package com.fmatusiak.travelagency.repository.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightArrivalEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FlightArrivalEntityRepository extends CrudRepository<FlightArrivalEntity, Long> {

    @Override
    <S extends FlightArrivalEntity> S save(S entity);

    @Override
    void deleteById(Long id);

    @Override
    Optional<FlightArrivalEntity> findById(Long id);
}
