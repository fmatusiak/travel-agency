package com.fmatusiak.travelagency.controller.database.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelPriceEntity;
import com.fmatusiak.travelagency.service.entity.hotel.HotelPriceEntityService;
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

@WebMvcTest(HotelPriceEntityController.class)
@RunWith(SpringRunner.class)
public class HotelPriceEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelPriceEntityService hotelPriceEntityService;

    @Test
    public void addHotelPrice() throws Exception {
        //when
        HotelPriceEntity hotelPriceEntity = new HotelPriceEntity();

        when(hotelPriceEntityService.addHotelPrice(any(HotelPriceEntity.class))).thenReturn(hotelPriceEntity);

        Gson gson = new Gson();
        String json = gson.toJson(hotelPriceEntity);

        //when & then
        mockMvc.perform(post("/v1/hotel/addHotelPrice")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
    }

    @Test
    public void getHotelPriceById() throws Exception {
        //when
        HotelPriceEntity hotelPriceEntity = new HotelPriceEntity(1L, "test", "test");

        when(hotelPriceEntityService.addHotelPrice(any(HotelPriceEntity.class))).thenReturn(hotelPriceEntity);

        when(hotelPriceEntityService.getHotelPriceById(1L)).thenReturn(hotelPriceEntity);

        //when & then
        mockMvc.perform(get("/v1/hotel/getHotelPrice/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency", is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.total", is("test")));
    }


    @Test
    public void deleteHotelPriceById() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/hotel/deleteHotelPrice/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}