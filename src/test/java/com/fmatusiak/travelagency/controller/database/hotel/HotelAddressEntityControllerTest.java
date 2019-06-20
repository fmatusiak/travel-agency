package com.fmatusiak.travelagency.controller.database.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelAddressEntity;
import com.fmatusiak.travelagency.domain.entity.hotel.HotelEntity;
import com.fmatusiak.travelagency.service.entity.hotel.HotelAddressEntityService;
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

@WebMvcTest(HotelAddressEntityController.class)
@RunWith(SpringRunner.class)
public class HotelAddressEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelAddressEntityService hotelAddressEntityService;

    @Test
    public void testAddHotelAddress() throws Exception {
        //given
        HotelAddressEntity hotelAddressEntity = new HotelAddressEntity();

        when(hotelAddressEntityService.addHotelAddress(any(HotelAddressEntity.class))).thenReturn(hotelAddressEntity);

        Gson gson = new Gson();
        String json = gson.toJson(hotelAddressEntity);

        //when & then
        mockMvc.perform(post("/v1/hotel/addHotelAddress")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
    }

    @Test
    public void testGetHotelAddressById() throws Exception {
        //given
        HotelAddressEntity hotelAddressEntity = new HotelAddressEntity(
                1L, "test", "test", new HotelEntity());

        when(hotelAddressEntityService.addHotelAddress(any(HotelAddressEntity.class))).thenReturn(hotelAddressEntity);

        when(hotelAddressEntityService.getHotelAddressById(1L)).thenReturn(hotelAddressEntity);

        //when & then
        mockMvc.perform(get("/v1/hotel/getHotelAddress/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cityName", is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.countryCode", is("test")));
    }

    @Test
    public void testDeleteHotelAddressById() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/hotel/deleteHotelAddress/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}