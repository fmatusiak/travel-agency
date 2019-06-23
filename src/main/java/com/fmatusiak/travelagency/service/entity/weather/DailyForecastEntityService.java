package com.fmatusiak.travelagency.service.entity.weather;

import com.fmatusiak.travelagency.domain.entity.weather.DailyForecastEntity;
import com.fmatusiak.travelagency.repository.weather.DailyForecastEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class DailyForecastEntityService {

    @Autowired
    private DailyForecastEntityRepository dailyForecastEntityRepository;

    public DailyForecastEntity addDailyforecast(DailyForecastEntity dailyForecastEntity) {
        return dailyForecastEntityRepository.save(dailyForecastEntity);
    }

    public Optional<DailyForecastEntity> getDailyforecastById(Long id) {
        return dailyForecastEntityRepository.findById(id);
    }

    public void deleteDailyforecastById(Long id) {
        dailyForecastEntityRepository.deleteById(id);
    }

}
