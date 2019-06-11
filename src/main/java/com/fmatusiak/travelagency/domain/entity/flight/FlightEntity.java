package com.fmatusiak.travelagency.domain.entity.flight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Flight")
public class FlightEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    int id;

    @OneToOne(mappedBy = "flightEntity", targetEntity = FlightArrivalEntity.class)
    @JoinColumn(name = "iataCode")
    FlightArrivalEntity flightArrivalEntity;

    @OneToOne(mappedBy = "flightEntity", targetEntity = FlightDepartureEntity.class)
    @JoinColumn(name = "iataCode")
    FlightDepartureEntity flightDepartureEntity;

    @OneToOne(mappedBy = "flightEntity", targetEntity = FlightPriceEntity.class)
    @JoinColumn(name = "price")
    FlightPriceEntity flightPriceEntity;

    @OneToOne(mappedBy = "flightPriceDetail", targetEntity = FlightPriceDetailPerAdultEntity.class)
    @JoinColumns({
            @JoinColumn(name = "travelClass", referencedColumnName = "travelClass"),
            @JoinColumn(name = "availabilityTickets", referencedColumnName = "availabilityTickets")
    })
    FlightPriceDetailPerAdultEntity flightPriceDetailPerAdultEntity;
}
