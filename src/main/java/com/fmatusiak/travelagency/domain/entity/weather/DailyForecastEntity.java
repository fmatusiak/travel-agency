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
    @Column(name = "ID", unique = true)
    private long id;

    @Column(name = "DATE")
    private String date;

    @Column(name = "MINIMUM_TEMPERATURE")
    private double minimumTemperature;

    @Column(name = "MAXIMUM_TEMPERATURE")
    private double maximumTemperature;

    @Column(name = "UNIT")
    private String unit;

    @OneToOne
    private CityEntity cityEntity;
}
