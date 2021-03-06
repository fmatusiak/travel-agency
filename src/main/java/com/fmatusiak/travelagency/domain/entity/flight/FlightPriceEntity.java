package com.fmatusiak.travelagency.domain.entity.flight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FLIGHT_PRICE")
public class FlightPriceEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private long id;

    @Column(name = "total")
    private double total;

    @OneToOne
    private FlightEntity flightEntity;

    public FlightPriceEntity(double total) {
        this.total = total;
    }
}
