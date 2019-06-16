package com.fmatusiak.travelagency.repository.location;

import com.fmatusiak.travelagency.domain.entity.location.LocationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocationEntityRepository extends CrudRepository<LocationEntity, Long> {

    @Override
    <S extends LocationEntity> S save(S entity);

    @Override
    void deleteById(Long id);

    @Override
    Optional<LocationEntity> findById(Long id);
}
