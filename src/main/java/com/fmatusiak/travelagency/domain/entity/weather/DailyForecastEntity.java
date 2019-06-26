package com.fmatusiak.travelagency.domain.entity.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DAILY_FORECAST")
public class DailyForecastEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private long id;

    @Column(name = "date")
    private String date;

    @Column(name = "minimum_temperature")
    private double minimumTemperature;

    @Column(name = "maximum_temperature")
    private double maximumTemperature;

    @Column(name = "unit")
    private String unit;

    @OneToOne
    private CityEntity cityEntity;

    public DailyForecastEntity(String date, double minimumTemperature, double maximumTemperature, String unit) {
        this.date = date;
        this.minimumTemperature = minimumTemperature;
        this.maximumTemperature = maximumTemperature;
        this.unit = unit;
    }
}
