package com.fmatusiak.travelagency.domain.amadeus.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LocationScore {
    private LocationData data;
    private LocationAddress address;
}
