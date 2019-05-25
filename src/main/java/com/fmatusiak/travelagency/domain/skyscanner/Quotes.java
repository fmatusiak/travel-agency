package com.fmatusiak.travelagency.domain.skyscanner;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quotes {
    @JsonProperty("MinPrice")
    private long price;

    @JsonProperty("OutboundLeg")
    private List<OutboundLeg> quotes;

    static class OutboundLeg {
        @JsonProperty("CarrierIds")
        private CarrierIds carrierIds;

        @JsonProperty("DepartureDate")
        private String departureDate;
    }

    static class CarrierIds {
        @JsonProperty
        private long id;
    }

}
