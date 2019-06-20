package com.fmatusiak.travelagency.controller.database.flight;

import com.fmatusiak.travelagency.domain.entity.flight.FlightEntity;
import com.fmatusiak.travelagency.domain.entity.flight.FlightPriceEntity;
import com.fmatusiak.travelagency.service.entity.flight.FlightPriceEntityService;
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

@WebMvcTest(FlightPriceEntity.class)
@RunWith(SpringRunner.class)
public class FlightPriceEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightPriceEntityService flightPriceEntityService;

    @Test
    public void testAddFlightPrice() throws Exception {
        //given
        FlightPriceEntity flightPriceEntity = new FlightPriceEntity();

        when(flightPriceEntityService
                .addFlightPrice(any(FlightPriceEntity.class)))
                .thenReturn(flightPriceEntity);

        Gson gson = new Gson();
        String json = gson.toJson(flightPriceEntity);

        //when & then
        mockMvc.perform(post("/v1/flight/addFlightPrice")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
    }

    @Test
    public void testGetFlightPriceById() throws Exception {
        //given
        FlightPriceEntity flightPriceEntity = new FlightPriceEntity(1L, 22.50, new FlightEntity());

        when(flightPriceEntityService
                .addFlightPrice(any(FlightPriceEntity.class)))
                .thenReturn(flightPriceEntity);

        when(flightPriceEntityService.getFlightPriceById(1L)).thenReturn(flightPriceEntity);

        //when & then
        mockMvc.perform(get("/v1/flight/getFlightPrice/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.total", is(22.50)));
    }

    @Test
    public void testDeleteFlightById() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/flight/deleteFlightPrice/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}