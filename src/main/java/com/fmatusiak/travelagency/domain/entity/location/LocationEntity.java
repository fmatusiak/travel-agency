package com.fmatusiak.travelagency.domain.entity.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Location")
public class LocationEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    int id;

    @OneToOne(mappedBy = "locationEntity", targetEntity = LocationDataEntity.class)
    @JoinColumns({
            @JoinColumn(name = "name", referencedColumnName = "name"),
            @JoinColumn(name = "detailedName", referencedColumnName = "detailedName")
    })
    LocationDataEntity locationDataEntity;

    @OneToOne(mappedBy = "locationEntity", targetEntity = LocationAddressEntity.class)
    @JoinColumns({
            @JoinColumn(name = "city", referencedColumnName = "cityName"),
            @JoinColumn(name = "cityCode", referencedColumnName = "cityCode"),
            @JoinColumn(name = "country", referencedColumnName = "countryName")
    })
    LocationAddressEntity locationAddressEntity;
}
