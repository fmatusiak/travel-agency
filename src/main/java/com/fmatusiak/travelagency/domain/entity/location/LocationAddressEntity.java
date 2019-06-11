package com.fmatusiak.travelagency.domain.entity.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LocationAddress")
public class LocationAddressEntity {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    int id;

    @Column(name = "cityName")
    String cityName;

    @Column(name = "cityCode")
    String cityCode;

    @Column(name = "countryName")
    String countryName;

    @OneToOne
    LocationEntity locationEntity;
}
