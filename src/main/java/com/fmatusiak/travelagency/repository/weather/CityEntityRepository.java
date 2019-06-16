package com.fmatusiak.travelagency.repository.weather;

import com.fmatusiak.travelagency.domain.entity.weather.CityEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CityEntityRepository extends CrudRepository<CityEntity, Long> {

    @Override
    <S extends CityEntity> S save(S entity);

    @Override
    Optional<CityEntity> findById(Long id);

    @Override
    void deleteById(Long id);
}
