package com.fmatusiak.travelagency.domain.entity.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HOTEL_PROPERTY")
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

    public HotelPropertyEntity(String chainCode, String name, int rating, String cityCode, HotelEntity hotelEntity) {
        this.chainCode = chainCode;
        this.name = name;
        this.rating = rating;
        this.cityCode = cityCode;
        this.hotelEntity = hotelEntity;
    }
}
