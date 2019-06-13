package com.fmatusiak.travelagency.domain.entity.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HOTEL")
public class HotelEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private int id;

    @JoinColumns({
            @JoinColumn(name = "name", referencedColumnName = "name"),
            @JoinColumn(name = "rating", referencedColumnName = "rating"),
            @JoinColumn(name = "cityCode", referencedColumnName = "cityCode")
    })
    @OneToOne(mappedBy = "hotelEntity")
    private HotelPropertyEntity hotelPropertyEntity;

    @JoinColumns({
            @JoinColumn(name = "city", referencedColumnName = "cityName"),
            @JoinColumn(name = "country", referencedColumnName = "countryCode")
    })
    @OneToOne(mappedBy = "hotelEntity")
    private HotelAddressEntity hotelAddressEntity;

    @JoinColumns({
            @JoinColumn(name = "phone", referencedColumnName = "phone"),
            @JoinColumn(name = "fax", referencedColumnName = "fax")
    })

    @OneToOne(mappedBy = "hotelEntity")
    private HotelContactEntity hotelContactEntity;
}
