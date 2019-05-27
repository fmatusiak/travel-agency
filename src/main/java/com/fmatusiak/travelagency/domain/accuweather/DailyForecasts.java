package com.fmatusiak.travelagency.domain.accuweather;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecasts {
    @JsonProperty("Date")
    private String date;

    @JsonProperty("Temperature")
    private Temperature temperature;

    static class Temperature {
        @JsonProperty("Minimum")
        private Minimum minimum;

        @JsonProperty("Maximum")
        private Maximum maximum;
    }

    static class Minimum {
        @JsonProperty("Value")
        private double value;

        @JsonProperty("Unit")
        private String unit;
    }

    static class Maximum {
        @JsonProperty("Value")
        private double value;

        @JsonProperty("Unit")
        private String unit;
    }

}
