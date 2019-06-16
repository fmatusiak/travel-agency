package com.fmatusiak.travelagency.repository.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelContactEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HotelContactEntityRepository extends CrudRepository<HotelContactEntity, Long> {

    @Override
    <S extends HotelContactEntity> S save(S entity);

    @Override
    Optional<HotelContactEntity> findById(Long id);

    @Override
    void deleteById(Long id);
}
