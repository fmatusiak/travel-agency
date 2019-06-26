package com.fmatusiak.travelagency.domain.entity.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LOCATION_ADDRESS")
public class LocationAddressEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private long id;

    @Column(name = "cityName")
    private String cityName;

    @Column(name = "cityCode")
    private String cityCode;

    @Column(name = "countryName")
    private String countryName;

    @OneToOne
    private LocationEntity locationEntity;

    public LocationAddressEntity(String cityName, String cityCode, String countryName) {
        this.cityName = cityName;
        this.cityCode = cityCode;
        this.countryName = countryName;
    }
}
