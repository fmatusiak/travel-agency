package com.fmatusiak.travelagency.domain.entity.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LocationData")
public class LocationDataEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "detailedName")
    String detailedName;

    @Column(name = "iataCode")
    String iataCode;

    @OneToOne(mappedBy = "locationDataEntity")
    LocationEntity locationEntity;
}
