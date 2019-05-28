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
public class City {

    @JsonProperty("Key")
    private String key;

    @JsonProperty("LocalizedName")
    private String localizedName;

    @JsonProperty("Region")
    private Region region;

    @JsonProperty("Country")
    private Country country;

    static class Region {
        @JsonProperty("LocalizedName")
        private String localizedName;
    }

    static class Country {
        @JsonProperty("LocalizedName")
        private String localizedName;
    }

}
