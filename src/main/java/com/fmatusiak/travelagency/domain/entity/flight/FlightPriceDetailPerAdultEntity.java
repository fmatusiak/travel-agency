package com.fmatusiak.travelagency.domain.entity.flight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FLIGHT_PRICE_DETAIL_PER_ADULT")
public class FlightPriceDetailPerAdultEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private long id;

    @Column(name = "travelClass")
    private String travelClass;

    @Column(name = "availabilityTickets")
    private int availability;

    @OneToOne
    private FlightEntity flightEntity;
}
