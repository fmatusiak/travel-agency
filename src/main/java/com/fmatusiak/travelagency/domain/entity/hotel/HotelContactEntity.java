package com.fmatusiak.travelagency.domain.entity.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HOTELS_CONTACTS")
public class HotelContactEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private int id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "fax")
    private String fax;

    @OneToOne
    private HotelEntity hotelEntity;
}
