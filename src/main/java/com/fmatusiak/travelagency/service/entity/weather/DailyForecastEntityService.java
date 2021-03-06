package com.fmatusiak.travelagency.service.entity.weather;

import com.fmatusiak.travelagency.domain.entity.weather.DailyForecastEntity;
import com.fmatusiak.travelagency.repository.weather.DailyForecastEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class DailyForecastEntityService {

    @Autowired
    private DailyForecastEntityRepository dailyForecastEntityRepository;

    public DailyForecastEntity addDailyforecast(DailyForecastEntity dailyForecastEntity) {
        return dailyForecastEntityRepository.save(dailyForecastEntity);
    }

    public DailyForecastEntity getDailyforecastById(Long id) {
        return dailyForecastEntityRepository.findById(id).orElse(null);
    }

    public void deleteDailyforecastById(Long id) {
        dailyForecastEntityRepository.deleteById(id);
    }

}
