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
    private long id;

    @JoinColumn(name = "id_flight_arrival", referencedColumnName = "id")
    @OneToOne(mappedBy = "flightEntity")
    private FlightArrivalEntity flightArrivalEntity;

    @JoinColumn(name = "id_flight_departure", referencedColumnName = "id")
    @OneToOne(mappedBy = "flightEntity")
    private FlightDepartureEntity flightDepartureEntity;

    @JoinColumn(name = "id_flight_price", referencedColumnName = "id")
    @OneToOne(mappedBy = "flightEntity")
    private FlightPriceEntity flightPriceEntity;


    @JoinColumn(name = "id_flight_Price_Detail_Per_Adult_Entity", referencedColumnName = "id")
    @OneToOne(mappedBy = "flightEntity")
    private FlightPriceDetailPerAdultEntity flightPriceDetailPerAdultEntity;
}
