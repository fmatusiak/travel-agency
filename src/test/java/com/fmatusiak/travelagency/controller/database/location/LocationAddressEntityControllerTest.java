package com.fmatusiak.travelagency.controller.database.location;

import com.fmatusiak.travelagency.domain.entity.location.LocationAddressEntity;
import com.fmatusiak.travelagency.domain.entity.location.LocationEntity;
import com.fmatusiak.travelagency.service.entity.location.LocationAddressEntityService;
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

@WebMvcTest(LocationAddressEntityController.class)
@RunWith(SpringRunner.class)
public class LocationAddressEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationAddressEntityService locationAddressEntityService;

    @Test
    public void testAddLocationAddress() throws Exception {
        //given
        LocationAddressEntity locationAddressEntity = new LocationAddressEntity();

        when(locationAddressEntityService.addLocationAddress(
                any(LocationAddressEntity.class)))
                .thenReturn(locationAddressEntity);

        Gson gson = new Gson();
        String json = gson.toJson(locationAddressEntity);

        //when & then
        mockMvc.perform(post("/v1/location/addLocationAddress")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
    }

    @Test
    public void testGetLocationAddressById() throws Exception {
        //given
        //given
        LocationAddressEntity locationAddressEntity = new LocationAddressEntity(
                1L, "test", "test", "test", new LocationEntity());

        when(locationAddressEntityService.addLocationAddress(
                any(LocationAddressEntity.class)))
                .thenReturn(locationAddressEntity);

        when(locationAddressEntityService.getLocationAddressById(1L)).thenReturn(locationAddressEntity);

        //when & then
        mockMvc.perform(get("/v1/location/getLocationAddress/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cityName", is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cityCode", is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.countryName", is("test")));
    }

    @Test
    public void testDeleteLocationAddressById() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/location/deleteLocationAddress/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}