package com.fmatusiak.travelagency.repository.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightPriceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FlightPriceEntityRepository extends CrudRepository<FlightPriceEntity, Long> {

    @Override
    <S extends FlightPriceEntity> S save(S entity);

    @Override
    Optional<FlightPriceEntity> findById(Long id);

    @Override
    void deleteById(Long id);
}
