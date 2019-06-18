package com.fmatusiak.travelagency.domain.entity.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HOTELS_PRICES")
public class HotelPriceEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private long id;

    @Column(name = "currency")
    private String currency;

    @Column(name = "total")
    private String total;
}
