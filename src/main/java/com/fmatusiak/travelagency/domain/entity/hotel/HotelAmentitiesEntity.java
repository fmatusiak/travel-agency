package com.fmatusiak.travelagency.domain.entity.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HotelAmentities")
public class HotelAmentitiesEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    int id;

    @Column(name = "amentities")
    List<String> amentities;

    @OneToOne(mappedBy = "hotelAmentitiesEntity")
    HotelEntity hotelEntity;
}
