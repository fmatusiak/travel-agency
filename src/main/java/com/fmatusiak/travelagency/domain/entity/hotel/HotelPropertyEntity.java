package com.fmatusiak.travelagency.domain.entity.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HotelProperty")
public class HotelPropertyEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    int id;

    @Column(name = "hotelId")
    String hotelId;

    @Column(name = "chainCode")
    String chainCode;

    @Column(name = "name")
    String name;

    @Column(name = "rating")
    int rating;

    @Column(name = "cityCode")
    String cityCode;

    @OneToOne(mappedBy = "hotelPropertyEntity")
    HotelEntity hotelEntity;
}
