package com.fmatusiak.travelagency.controller.database.weather;

import com.fmatusiak.travelagency.domain.entity.weather.DailyForecastEntity;
import com.fmatusiak.travelagency.service.entity.weather.DailyForecastEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/dailyForecast")
public class DailyForecastEntityController {

    @Autowired
    private DailyForecastEntityService dailyForecastEntityService;

    @PostMapping(value = "addDailyForecast")
    public DailyForecastEntity addDailyforecast(@RequestBody DailyForecastEntity dailyForecastEntity) {
        return dailyForecastEntityService.addDailyforecast(dailyForecastEntity);
    }

    @GetMapping(value = "getDailyForecast/{id}")
    public Optional<DailyForecastEntity> getDailyforecastById(@PathVariable long id) {
        return dailyForecastEntityService.getDailyforecastById(id);
    }

    @DeleteMapping(value = "deleteDailyForecast/{id}")
    public void deleteDailyforecastById(@PathVariable long id) {
        dailyForecastEntityService.deleteDailyforecastById(id);
    }
}
