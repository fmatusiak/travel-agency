package com.fmatusiak.travelagency.domain.entity.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Hotel")
public class HotelEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    int id;

    @OneToOne(mappedBy = "hotelEntity", targetEntity = HotelPropertyEntity.class)
    @JoinColumns({
            @JoinColumn(name = "name", referencedColumnName = "name"),
            @JoinColumn(name = "rating", referencedColumnName = "rating"),
            @JoinColumn(name = "cityCode", referencedColumnName = "cityCode")
    })
    HotelPropertyEntity hotelPropertyEntity;

    @OneToOne(mappedBy = "hotelEntity", targetEntity = HotelAddressEntity.class)
    @JoinColumns({
            @JoinColumn(name = "city", referencedColumnName = "cityName"),
            @JoinColumn(name = "country", referencedColumnName = "countryCode")
    })
    HotelAddressEntity hotelAddressEntity;

    @OneToOne(mappedBy = "hotelEntity", targetEntity = HotelContactEntity.class)
    @JoinColumns({
            @JoinColumn(name = "phone", referencedColumnName = "phone"),
            @JoinColumn(name = "fax", referencedColumnName = "fax")
    })
    HotelContactEntity hotelContactEntity;

    @OneToOne(mappedBy = "hotelEntity", targetEntity = HotelAmentitiesEntity.class)
    @JoinColumn(name = "amentities")
    HotelAmentitiesEntity hotelAmentitiesEntity;

}
