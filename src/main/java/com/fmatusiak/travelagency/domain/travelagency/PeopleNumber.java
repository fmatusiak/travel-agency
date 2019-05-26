package com.fmatusiak.travelagency.domain.travelagency;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Component
public class PeopleNumber {
    private int minNumberPeople;
    private int maxNumberPeople;

    public PeopleNumber(int minNumberPeople) {
        this.minNumberPeople = minNumberPeople;
    }
}
