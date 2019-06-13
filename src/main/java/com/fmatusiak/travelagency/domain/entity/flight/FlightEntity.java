package com.fmatusiak.travelagency.domain.entity.flight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FLIGHT")
public class FlightEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    int id;

    @JoinColumn(name = "iataCode_flight_arrival", referencedColumnName = "iataCode")
    @OneToOne(mappedBy = "flightEntity")
    FlightArrivalEntity flightArrivalEntity;

    @JoinColumn(name = "iataCode_flight_departure", referencedColumnName = "iataCode")
    @OneToOne(mappedBy = "flightEntity")
    FlightDepartureEntity flightDepartureEntity;

    @JoinColumn(name = "flight_price", referencedColumnName = "price")
    @OneToOne(mappedBy = "flightEntity")
    FlightPriceEntity flightPriceEntity;

    @JoinColumns({
            @JoinColumn(name = "flight_travelClass", referencedColumnName = "travelClass"),
            @JoinColumn(name = "flight_availabilityTickets", referencedColumnName = "availabilityTickets")
    })
    @OneToOne(mappedBy = "flightEntity")
    FlightPriceDetailPerAdultEntity flightPriceDetailPerAdultEntity;
}
