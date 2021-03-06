package com.fmatusiak.travelagency.domain.entity.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HOTEL_PRICE")
public class HotelPriceEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private long id;

    @Column(name = "currency")
    private String currency;

    @Column(name = "total")
    private String total;

    public HotelPriceEntity(String currency, String total) {
        this.currency = currency;
        this.total = total;
    }
}
