package com.fmatusiak.travelagency.controller.database.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelContactEntity;
import com.fmatusiak.travelagency.domain.entity.hotel.HotelEntity;
import com.fmatusiak.travelagency.service.entity.hotel.HotelContactEntityService;
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

@WebMvcTest(HotelContactEntityController.class)
@RunWith(SpringRunner.class)
public class HotelContactEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelContactEntityService hotelContactEntityService;

    @Test
    public void testAddHotelContact() throws Exception {
        //given
        HotelContactEntity hotelContactEntity = new HotelContactEntity();

        when(hotelContactEntityService.addHotelContact(any(HotelContactEntity.class))).thenReturn(hotelContactEntity);

        Gson gson = new Gson();
        String json = gson.toJson(hotelContactEntity);

        //when & then
        mockMvc.perform(post("/v1/hotel/addHotelContact")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
    }

    @Test
    public void testGetHotelContactById() throws Exception {
        //given
        HotelContactEntity hotelContactEntity = new HotelContactEntity(
                1L, "1234", "1234", new HotelEntity());

        when(hotelContactEntityService.addHotelContact(any(HotelContactEntity.class))).thenReturn(hotelContactEntity);

        when(hotelContactEntityService.getHotelContactById(1L)).thenReturn(hotelContactEntity);

        //when & then
        mockMvc.perform(get("/v1/hotel/getHotelContact/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone", is("1234")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fax", is("1234")));
    }

    @Test
    public void testDeleteHotelContactById() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/hotel/deleteHotelContact/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}