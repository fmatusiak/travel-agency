package com.fmatusiak.travelagency.controller.database.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightDepartureEntity;
import com.fmatusiak.travelagency.domain.entity.flight.FlightEntity;
import com.fmatusiak.travelagency.service.entity.flight.FlightDepartureEntityService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FlightDepartureEntityController.class)
public class FlightDepartureEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightDepartureEntityService flightDepartureEntityService;

    @Test
    public void testAddflightDeparture() throws Exception {
        //given
        FlightDepartureEntity flightDepartureEntity = new FlightDepartureEntity();

        when(flightDepartureEntityService.addFlightDeparture(
                any(FlightDepartureEntity.class))).thenReturn(flightDepartureEntity);

        Gson gson = new Gson();
        String json = gson.toJson(flightDepartureEntity);

        //when & then
        mockMvc.perform(post("/v1/flight/addFlightDeparture")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
    }

    @Test
    public void testFlightDepartureById() throws Exception {
        //given
        FlightDepartureEntity flightDepartureEntity =
                new FlightDepartureEntity(1L, "test", "test", new FlightEntity());

        when(flightDepartureEntityService
                .getFlightDepartureById(1L))
                .thenReturn(flightDepartureEntity);

        when(flightDepartureEntityService.getFlightDepartureById(1L)).thenReturn(flightDepartureEntity);

        //when & then
        mockMvc.perform(get("/v1/flight/getFlightDeparture/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.iataCode", Matchers.is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.at", Matchers.is("test")));
    }

    @Test
    public void testDeleteflightDepartureById() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/flight/deleteFlightDeparture/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}