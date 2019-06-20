package com.fmatusiak.travelagency.controller.database.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelAddressEntity;
import com.fmatusiak.travelagency.domain.entity.hotel.HotelContactEntity;
import com.fmatusiak.travelagency.domain.entity.hotel.HotelEntity;
import com.fmatusiak.travelagency.domain.entity.hotel.HotelPropertyEntity;
import com.fmatusiak.travelagency.service.entity.hotel.HotelEntityService;
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

@WebMvcTest(HotelEntityController.class)
@RunWith(SpringRunner.class)
public class HotelEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelEntityService hotelEntityService;

    @Test
    public void addHotel() throws Exception {
        //given
        HotelEntity hotelEntity = new HotelEntity();

        when(hotelEntityService.addHotel(any(HotelEntity.class))).thenReturn(hotelEntity);

        Gson gson = new Gson();
        String json = gson.toJson(hotelEntity);

        //when & then
        mockMvc.perform(post("/v1/hotel/addHotel")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
    }

    @Test
    public void getHotelById() throws Exception {
        //given
        HotelEntity hotelEntity = new HotelEntity(
                1L, new HotelPropertyEntity(), new HotelAddressEntity(), new HotelContactEntity());

        when(hotelEntityService.addHotel(any(HotelEntity.class))).thenReturn(hotelEntity);
        when(hotelEntityService.getHotelById(1L)).thenReturn(hotelEntity);

        //when & then
        mockMvc.perform(get("/v1/hotel/getHotel/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)));
    }

    @Test
    public void deleteHotelById() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/hotel/deleteHotel/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}