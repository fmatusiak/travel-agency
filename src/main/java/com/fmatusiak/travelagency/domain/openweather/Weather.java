package com.fmatusiak.travelagency.domain.openweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    @JsonProperty("list")
    private List list;

    static class List {
        @JsonProperty("name")
        private String name;

        @JsonProperty("main")
        private Main main;
    }

    static class Main {
        @JsonProperty("temp")
        private long temp;

        @JsonProperty("temp_min")
        private long temp_min;

        @JsonProperty("temp_max")
        private long temp_max;
    }

}
