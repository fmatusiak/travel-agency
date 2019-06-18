package com.fmatusiak.travelagency.domain.entity.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HOTELS_ADDRESS")
public class HotelAddressEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private long id;

    @Column(name = "cityName")
    private String cityName;

    @Column(name = "countryCode")
    private String countryCode;

    @OneToOne
    private HotelEntity hotelEntity;
}
