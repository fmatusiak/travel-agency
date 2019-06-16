package com.fmatusiak.travelagency.repository.weather;

import com.fmatusiak.travelagency.domain.entity.weather.DailyForecastEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DailyForecastEntityRepository extends CrudRepository<DailyForecastEntity, Long> {

    @Override
    <S extends DailyForecastEntity> S save(S entity);

    @Override
    Optional<DailyForecastEntity> findById(Long id);

    @Override
    void deleteById(Long id);
}
