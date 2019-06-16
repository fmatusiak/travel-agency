package com.fmatusiak.travelagency.repository.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FlightEntityRepository extends CrudRepository<FlightEntity, Long> {

    @Override
    <S extends FlightEntity> S save(S entity);

    @Override
    Optional<FlightEntity> findById(Long id);

    @Override
    void deleteById(Long id);
}
