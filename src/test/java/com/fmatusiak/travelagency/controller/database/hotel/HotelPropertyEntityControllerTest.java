package com.fmatusiak.travelagency.controller.database.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelEntity;
import com.fmatusiak.travelagency.domain.entity.hotel.HotelPropertyEntity;
import com.fmatusiak.travelagency.service.entity.hotel.HotelPropertyEntityService;
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

@WebMvcTest(HotelPropertyEntityController.class)
@RunWith(SpringRunner.class)
public class HotelPropertyEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelPropertyEntityService hotelPropertyEntityService;

    @Test
    public void addHotelProperty() throws Exception {
        //given
        HotelPropertyEntity hotelPropertyEntity = new HotelPropertyEntity();

        when(hotelPropertyEntityService.addHotelProperty(
                any(HotelPropertyEntity.class)))
                .thenReturn(hotelPropertyEntity);

        Gson gson = new Gson();
        String json = gson.toJson(hotelPropertyEntity);

        //when & then
        mockMvc.perform(post("/v1/hotel/addHotelProperty")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
    }

    @Test
    public void getHotelPropertyById() throws Exception {
        //given
        HotelPropertyEntity hotelPropertyEntity = new HotelPropertyEntity(
                1L, "test", "test", "test"
                , 5, "test", new HotelEntity());

        when(hotelPropertyEntityService.addHotelProperty(
                any(HotelPropertyEntity.class)))
                .thenReturn(hotelPropertyEntity);

        when(hotelPropertyEntityService.getHotelPropertyById(1L)).thenReturn(hotelPropertyEntity);

        //when & then
        mockMvc.perform(get("/v1/hotel/getHotelProperty/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hotelId", is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.chainCode", is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rating", is(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cityCode", is("test")));
    }

    @Test
    public void deleteHotelPropertyById() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/hotel/deleteHotelProperty/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}