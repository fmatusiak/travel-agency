package com.fmatusiak.travelagency.domain.entity.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CITY")
public class CityEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private long id;

    @Column(name = "key")
    private String key;

    @Column(name = "localizedName")
    private String localizedName;

    @Column(name = "regionName")
    private String regionName;

    @Column(name = "countryName")
    private String countryName;

    @OneToOne(mappedBy = "cityEntity")
    @JoinColumn(name = "id_daily_dorecast", referencedColumnName = "id")
    private DailyForecastEntity dailyForecastEntity;
}
