package com.fmatusiak.travelagency.domain.entity.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HOTELS_PROPERTIES")
public class HotelPropertyEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private long id;

    @Column(name = "hotelId")
    private String hotelId;

    @Column(name = "chainCode")
    private String chainCode;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private int rating;

    @Column(name = "cityCode")
    private String cityCode;

    @OneToOne
    private HotelEntity hotelEntity;
}
