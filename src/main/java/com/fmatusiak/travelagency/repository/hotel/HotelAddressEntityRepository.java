package com.fmatusiak.travelagency.repository.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelAddressEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HotelAddressEntityRepository extends CrudRepository<HotelAddressEntity, Long> {
    @Override
    <S extends HotelAddressEntity> S save(S entity);

    @Override
    Optional<HotelAddressEntity> findById(Long id);

    @Override
    void deleteById(Long id);
}
