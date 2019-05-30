package com.fmatusiak.travelagency.domain.amadeus.flight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class FlightPersonalize {

    private String originPlace;
    private String destinationPlace;
    private String departureDate;
    private String returnDate;
    private int adultsQuantity;
    private int childrenQuantity;
    private int seniorsQuantity;
    private String travelClass;


    public static final class FlightPersonalizeBuilder {
        private String originPlace;
        private String destinationPlace;
        private String departureDate;
        private String returnDate;
        private int adultsQuantity;
        private int childrenQuantity;
        private int seniorsQuantity;
        private String travelClass;

        public FlightPersonalizeBuilder originPlace(String originPlace) {
            this.originPlace = originPlace;
            return this;
        }

        public FlightPersonalizeBuilder destinationPlace(String destinationPlace) {
            this.destinationPlace = destinationPlace;
            return this;
        }

        public FlightPersonalizeBuilder departureDate(String departureDate) {
            this.departureDate = departureDate;
            return this;
        }

        public FlightPersonalizeBuilder returnDate(String returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public FlightPersonalizeBuilder adultsQuantity(int adultsQuantity) {
            this.adultsQuantity = adultsQuantity;
            return this;
        }

        public FlightPersonalizeBuilder childrenQuantity(int childrenQuantity) {
            this.childrenQuantity = childrenQuantity;
            return this;
        }

        public FlightPersonalizeBuilder seniorsQuantity(int seniorsQuantity) {
            this.seniorsQuantity = seniorsQuantity;
            return this;
        }

        public FlightPersonalizeBuilder travelClass(String travelClass) {
            this.travelClass = travelClass;
            return this;
        }

        public FlightPersonalize build() throws InstantiationException {
            if (originPlace.isEmpty()) {
                throw new InstantiationException("Origin place is not empty");
            }
            if (destinationPlace.isEmpty()) {
                throw new InstantiationException("Destination place is not empty");
            }
            if (departureDate.isEmpty()) {
                throw new InstantiationException("Departure date is not empty");
            }

            FlightPersonalize flightPersonalize = new FlightPersonalize();
            flightPersonalize.originPlace = this.originPlace;
            flightPersonalize.destinationPlace = this.destinationPlace;
            flightPersonalize.departureDate = this.departureDate;
            flightPersonalize.returnDate = this.returnDate;
            flightPersonalize.adultsQuantity = this.adultsQuantity;
            flightPersonalize.childrenQuantity = this.childrenQuantity;
            flightPersonalize.seniorsQuantity = this.seniorsQuantity;
            return flightPersonalize;
        }

    }
}
