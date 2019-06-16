package com.fmatusiak.travelagency.repository.location;

import com.fmatusiak.travelagency.domain.entity.location.LocationAddressEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocationAddressEntityRepository extends CrudRepository<LocationAddressEntity, Long> {

    @Override
    <S extends LocationAddressEntity> S save(S entity);

    @Override
    Optional<LocationAddressEntity> findById(Long id);

    @Override
    void deleteById(Long id);
}
