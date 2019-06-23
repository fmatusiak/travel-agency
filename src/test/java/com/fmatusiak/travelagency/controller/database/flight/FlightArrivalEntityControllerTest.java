package com.fmatusiak.travelagency.controller.database.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightArrivalEntity;
import com.fmatusiak.travelagency.domain.entity.flight.FlightEntity;
import com.fmatusiak.travelagency.service.entity.flight.FlightArrivalEntityService;
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


@WebMvcTest(FlightArrivalEntityController.class)
@RunWith(SpringRunner.class)
public class FlightArrivalEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightArrivalEntityService flightArrivalEntityService;

    @Test
    public void testAddflightArrival() throws Exception {
        //given
        FlightArrivalEntity flightArrivalEntity = new FlightArrivalEntity();

        when(flightArrivalEntityService.addFlightArrival(
                any(FlightArrivalEntity.class)))
                .thenReturn(flightArrivalEntity);

        Gson gson = new Gson();
        String json = gson.toJson(flightArrivalEntity);

        //when & then
        mockMvc.perform(post("/v1/flight/addFlightArrival")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
    }

    @Test
    public void testGetFlightArrivalById() throws Exception {
        //given
        FlightArrivalEntity flightArrivalEntity =
                new FlightArrivalEntity(1L, "test", "test", new FlightEntity());

        when(flightArrivalEntityService
                .addFlightArrival(any(FlightArrivalEntity.class)))
                .thenReturn(flightArrivalEntity);

        when(flightArrivalEntityService.getFlightArrivalById(1L)).thenReturn(flightArrivalEntity);

        //when & then
        mockMvc.perform(get("/v1/flight/getFlightArrival/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.iataCode", is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.at", is("test")));
    }

    @Test
    public void testDeleteFlightArrivalById() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/flight/deleteFlightArrival/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}