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
    private int id;

    @Column(name = "cityName")
    private String cityName;

    @Column(name = "cityCode")
    private String cityCode;

    @Column(name = "countryName")
    private String countryName;

    @OneToOne
    private LocationEntity locationEntity;
}
