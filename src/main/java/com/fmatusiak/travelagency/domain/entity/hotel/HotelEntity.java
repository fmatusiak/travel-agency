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
    private long id;

    @JoinColumn(name = "id_ hotelProperty", referencedColumnName = "id")
    @OneToOne(mappedBy = "hotelEntity")
    private HotelPropertyEntity hotelPropertyEntity;


    @JoinColumn(name = "id_hotel_address", referencedColumnName = "id")
    @OneToOne(mappedBy = "hotelEntity")
    private HotelAddressEntity hotelAddressEntity;


    @JoinColumn(name = "id_hotel_contact", referencedColumnName = "id")
    @OneToOne(mappedBy = "hotelEntity")
    private HotelContactEntity hotelContactEntity;

    public HotelEntity(
            HotelPropertyEntity hotelPropertyEntity
            , HotelAddressEntity hotelAddressEntity
            , HotelContactEntity hotelContactEntity) {
        this.hotelPropertyEntity = hotelPropertyEntity;
        this.hotelAddressEntity = hotelAddressEntity;
        this.hotelContactEntity = hotelContactEntity;
    }
}
