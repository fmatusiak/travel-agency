package com.fmatusiak.travelagency.controller.database.flight;

import com.fmatusiak.travelagency.domain.amadeus.enums.TravelClass;
import com.fmatusiak.travelagency.domain.entity.flight.FlightEntity;
import com.fmatusiak.travelagency.domain.entity.flight.FlightPriceDetailPerAdultEntity;
import com.fmatusiak.travelagency.service.entity.flight.FlightPriceDetailPerAdultEntityService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FlightPriceDetailPerAdultEntityController.class)
@RunWith(SpringRunner.class)
public class FlightPriceDetailPerAdultEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightPriceDetailPerAdultEntityService flightPriceDetailPerAdultEntityService;

    @Test
    public void addFlightPriceDetailPerAdult() throws Exception {
        //given
        FlightPriceDetailPerAdultEntity flightPriceDetailPerAdultEntity = new FlightPriceDetailPerAdultEntity();

        when(flightPriceDetailPerAdultEntityService
                .addFlightPriceDetailPerAdult(any(FlightPriceDetailPerAdultEntity.class)))
                .thenReturn(flightPriceDetailPerAdultEntity);

        Gson gson = new Gson();
        String json = gson.toJson(flightPriceDetailPerAdultEntity);

        //when & then
        mockMvc.perform(post("/v1/flight/addFlightPriceDetail")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
    }

    @Test
    public void getFlightPricedetailPerAdultById() throws Exception {
        //given
        FlightPriceDetailPerAdultEntity flightPriceDetailPerAdultEntity = new FlightPriceDetailPerAdultEntity(
                1L, TravelClass.ECONOMY.getName(), 5, new FlightEntity());

        when(flightPriceDetailPerAdultEntityService
                .addFlightPriceDetailPerAdult(any(FlightPriceDetailPerAdultEntity.class)))
                .thenReturn(flightPriceDetailPerAdultEntity);

        when(flightPriceDetailPerAdultEntityService
                .getFlightPriceDetailPerAdultyById(1L))
                .thenReturn(flightPriceDetailPerAdultEntity);

        //when & then
        mockMvc.perform(get("/v1/flight/getFlightPriceDetail/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.travelClass", is("ECONOMY")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.availability", is(5)));
    }

    @Test
    public void deleteFlightPricedetailPerAdultById() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/flight/deleteFlightPriceDetail/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}