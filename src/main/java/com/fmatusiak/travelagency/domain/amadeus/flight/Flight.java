package com.fmatusiak.travelagency.domain.amadeus.flight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Flight {


}
