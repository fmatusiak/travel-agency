package com.fmatusiak.travelagency.repository.location;

import com.fmatusiak.travelagency.domain.entity.location.LocationDataEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocationDataEntityRepository extends CrudRepository<LocationDataEntity, Long> {

    @Override
    <S extends LocationDataEntity> S save(S entity);

    @Override
    Optional<LocationDataEntity> findById(Long id);

    @Override
    void deleteById(Long id);
}
