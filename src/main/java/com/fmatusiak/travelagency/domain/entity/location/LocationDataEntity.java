package com.fmatusiak.travelagency.domain.entity.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LOCATIONS_DATES")
public class LocationDataEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "detailedName")
    private String detailedName;

    @Column(name = "iataCode")
    private String iataCode;

    @OneToOne
    private LocationEntity locationEntity;
}
