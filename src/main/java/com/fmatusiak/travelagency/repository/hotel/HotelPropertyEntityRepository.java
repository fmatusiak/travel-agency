package com.fmatusiak.travelagency.repository.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelPropertyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HotelPropertyEntityRepository extends CrudRepository<HotelPropertyEntity, Long> {

    @Override
    <S extends HotelPropertyEntity> S save(S entity);

    @Override
    Optional<HotelPropertyEntity> findById(Long id);

    @Override
    void deleteById(Long id);
}
