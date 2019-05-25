package com.fmatusiak.travelagency.domain.skyscanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class FlightSearch {
    private String departureCity;
    private String arrivalCity;
    private String departureDates;
    private String arrivalDates;

    public FlightSearch(String departureCity, String arrivalCity, String departureDates) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureDates = departureDates;
    }

    public static FlightSearchBuilder builder() {
        return new FlightSearchBuilder();
    }

    static class FlightSearchBuilder {
        private String departureCity;
        private String arrivalCity;
        private String departureDates;
        private String arrivalDates;

        public FlightSearchBuilder departureCity(String departureCity) {
            this.departureCity = departureCity;
            return this;
        }

        public FlightSearchBuilder arrivalCity(String arrivalCity) {
            this.arrivalCity = arrivalCity;
            return this;
        }

        public FlightSearchBuilder departureDates(String departureDates) {
            this.departureDates = departureDates;
            return this;
        }

        public FlightSearchBuilder arrivalDates(String arrivalDates) {
            this.arrivalDates = departureDates;
            return this;
        }

        public FlightSearch build() {
            if (departureCity == null || departureCity.isEmpty())
                throw new IllegalArgumentException("Departure City must be non-empty value");
            if (arrivalCity == null || arrivalCity.isEmpty())
                throw new IllegalArgumentException("Arrival City must be non-empty value");
            if (departureDates == null)
                throw new IllegalArgumentException("Departure Dates must be non-empty value");

            return new FlightSearch(departureCity, arrivalCity, departureDates, arrivalDates);
        }

    }

}
