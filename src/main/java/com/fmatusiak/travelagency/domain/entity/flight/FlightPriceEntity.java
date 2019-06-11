package com.fmatusiak.travelagency.domain.entity.flight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FlightPrice")
public class FlightPriceEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    int id;

    @Column(name = "total")
    double total;

    @OneToOne(mappedBy = "flightPriceEntity")
    FlightEntity flightEntity;
}
