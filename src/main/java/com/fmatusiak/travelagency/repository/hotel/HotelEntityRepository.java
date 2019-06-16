package com.fmatusiak.travelagency.repository.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HotelEntityRepository extends CrudRepository<HotelEntity, Long> {

    @Override
    <S extends HotelEntity> S save(S entity);

    @Override
    Optional<HotelEntity> findById(Long id);

    @Override
    void deleteById(Long id);
}
