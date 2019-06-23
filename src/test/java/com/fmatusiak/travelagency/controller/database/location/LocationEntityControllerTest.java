package com.fmatusiak.travelagency.controller.database.location;

import com.fmatusiak.travelagency.domain.entity.location.LocationAddressEntity;
import com.fmatusiak.travelagency.domain.entity.location.LocationDataEntity;
import com.fmatusiak.travelagency.domain.entity.location.LocationEntity;
import com.fmatusiak.travelagency.service.entity.location.LocationEntityService;
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

@WebMvcTest(LocationEntityController.class)
@RunWith(SpringRunner.class)
public class LocationEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationEntityService locationEntityService;

    @Test
    public void testAddLocation() throws Exception {
        //given
        LocationEntity locationEntity = new LocationEntity();

        when(locationEntityService.addLocation(any(LocationEntity.class))).thenReturn(locationEntity);

        Gson gson = new Gson();
        String json = gson.toJson(locationEntity);

        //when & then
        mockMvc.perform(post("/v1/location/addLocation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
    }

    @Test
    public void testGetLocationById() throws Exception {
        //given
        LocationEntity locationEntity = new LocationEntity(
                1L, new LocationDataEntity(), new LocationAddressEntity());

        when(locationEntityService.addLocation(any(LocationEntity.class))).thenReturn(locationEntity);
        when(locationEntityService.getLocationById(1L)).thenReturn(locationEntity);

        //when & then
        mockMvc.perform(get("/v1/location/getLocation/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)));
    }

    @Test
    public void testDeleteLocationById() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/location/deleteLocation/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}