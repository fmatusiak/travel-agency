package com.fmatusiak.travelagency.domain.entity.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HotelAmentities")
public class HotelContactEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    int id;

    @OneToOne(mappedBy = "hotelContactEntity")
    HotelEntity hotelEntity;

    @Column(name = "phone")
    private String phone;

    @Column(name = "fax")
    private String fax;
}
