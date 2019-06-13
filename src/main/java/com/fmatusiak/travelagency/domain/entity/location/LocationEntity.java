package com.fmatusiak.travelagency.domain.entity.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LOCATION")
public class LocationEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private int id;

    @JoinColumns({
            @JoinColumn(name = "location_name", referencedColumnName = "name"),
            @JoinColumn(name = "location_detailedName", referencedColumnName = "detailedName")
    })
    @OneToOne(mappedBy = "locationEntity")
    private LocationDataEntity locationDataEntity;

    @JoinColumns({
            @JoinColumn(name = "city", referencedColumnName = "cityName"),
            @JoinColumn(name = "cityCode", referencedColumnName = "cityCode"),
            @JoinColumn(name = "country", referencedColumnName = "countryName")
    })
    @OneToOne(mappedBy = "locationEntity")
    private LocationAddressEntity locationAddressEntity;
}
