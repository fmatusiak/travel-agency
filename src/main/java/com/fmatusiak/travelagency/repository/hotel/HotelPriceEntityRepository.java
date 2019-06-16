package com.fmatusiak.travelagency.repository.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelPriceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HotelPriceEntityRepository extends CrudRepository<HotelPriceEntity, Long> {

    @Override
    <S extends HotelPriceEntity> S save(S entity);

    @Override
    Optional<HotelPriceEntity> findById(Long id);

    @Override
    void deleteById(Long id);
}
