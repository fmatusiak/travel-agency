package com.fmatusiak.travelagency.domain.entity.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HotelAddress")
public class HotelAddressEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    int id;

    @Column(name = "cityName")
    String cityName;

    @Column(name = "countryCode")
    String countryCode;

    @OneToOne(mappedBy = "hotelAddressEntity")
    HotelEntity hotelEntity;
}
