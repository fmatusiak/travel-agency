package com.fmatusiak.travelagency.domain.entity.flight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FLIGHTS_ARRIVALS")
public class FlightArrivalEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private long id;

    @Column(name = "iataCode")
    private String iataCode;

    @Column(name = "at")
    private String at;

    @OneToOne
    private FlightEntity flightEntity;
}
