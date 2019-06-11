package com.fmatusiak.travelagency.domain.entity.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "City")
public class City {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    int id;

    @Column(name = "key")
    String key;

    @Column(name = "localizedName")
    String localizedName;

    @Column(name = "regionName")
    String regionName;

    @Column(name = "countryNane")
    String countryNane;

}
