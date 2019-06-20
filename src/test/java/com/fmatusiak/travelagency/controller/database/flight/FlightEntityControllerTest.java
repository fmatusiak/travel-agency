package com.fmatusiak.travelagency.controller.database.flight;

import com.fmatusiak.travelagency.domain.entity.flight.*;
import com.fmatusiak.travelagency.service.entity.flight.FlightEntityService;
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

@WebMvcTest(FlightEntityController.class)
@RunWith(SpringRunner.class)
public class FlightEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightEntityService flightEntityService;

    @Test
    public void testAddFlight() throws Exception {
        //given
        FlightEntity flightEntity = new FlightEntity();

        when(flightEntityService.addFlightEntity(any(FlightEntity.class))).thenReturn(flightEntity);

        Gson gson = new Gson();
        String json = gson.toJson(flightEntity);

        //when & then
        mockMvc.perform(post("/v1/flight/addFlight")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
    }

    @Test
    public void testGetFlightById() throws Exception {
        //given
        FlightEntity flightEntity = new FlightEntity(
                1L, new FlightArrivalEntity(), new FlightDepartureEntity()
                , new FlightPriceEntity(), new FlightPriceDetailPerAdultEntity());

        when(flightEntityService.addFlightEntity(any(FlightEntity.class))).thenReturn(flightEntity);

        when(flightEntityService.getFlightEntityById(1L)).thenReturn(flightEntity);

        //when & then
        mockMvc.perform(get("/v1/flight/getFlight/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)));

    }

    @Test
    public void testDeleteFlightById() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/flight/deleteFlight/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}