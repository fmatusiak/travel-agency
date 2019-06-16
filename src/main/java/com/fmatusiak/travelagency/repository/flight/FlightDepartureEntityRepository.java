package com.fmatusiak.travelagency.repository.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightDepartureEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FlightDepartureEntityRepository extends CrudRepository<FlightDepartureEntity, Long> {

    @Override
    <S extends FlightDepartureEntity> S save(S entity);

    @Override
    Optional<FlightDepartureEntity> findById(Long id);

    @Override
    void deleteById(Long id);
}
