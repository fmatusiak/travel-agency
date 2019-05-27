package com.fmatusiak.travelagency.domain.skyscanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class Flight {
    private String departureCity;
    private String arrivalCity;
    private String departureDates;
    private String arrivalDates;

    public Flight(String departureCity, String arrivalCity, String departureDates) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureDates = departureDates;
    }

    public static FlightBuilder builder() {
        return new FlightBuilder();
    }

    static class FlightBuilder {
        private String departureCity;
        private String arrivalCity;
        private String departureDates;
        private String arrivalDates;

        public FlightBuilder departureCity(String departureCity) {
            this.departureCity = departureCity;
            return this;
        }

        public FlightBuilder arrivalCity(String arrivalCity) {
            this.arrivalCity = arrivalCity;
            return this;
        }

        public FlightBuilder departureDates(String departureDates) {
            this.departureDates = departureDates;
            return this;
        }

        public FlightBuilder arrivalDates(String arrivalDates) {
            this.arrivalDates = departureDates;
            return this;
        }

        public Flight build() {
            if (departureCity == null || departureCity.isEmpty())
                throw new IllegalArgumentException("Departure City must be non-empty value");
            if (arrivalCity == null || arrivalCity.isEmpty())
                throw new IllegalArgumentException("Arrival City must be non-empty value");
            if (departureDates == null)
                throw new IllegalArgumentException("Departure Dates must be non-empty value");
            return new Flight(departureCity, arrivalCity, departureDates, arrivalDates);
        }

    }

}
