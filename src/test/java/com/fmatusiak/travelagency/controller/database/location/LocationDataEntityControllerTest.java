package com.fmatusiak.travelagency.controller.database.location;

import com.fmatusiak.travelagency.domain.entity.location.LocationDataEntity;
import com.fmatusiak.travelagency.domain.entity.location.LocationEntity;
import com.fmatusiak.travelagency.service.entity.location.LocationDataEntityService;
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

@WebMvcTest(LocationDataEntityController.class)
@RunWith(SpringRunner.class)
public class LocationDataEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationDataEntityService locationDataEntityService;

    @Test
    public void testAddLocationData() throws Exception {
        //given
        LocationDataEntity locationDataEntity = new LocationDataEntity();

        when(locationDataEntityService.addLocationData(any(LocationDataEntity.class))).thenReturn(locationDataEntity);

        Gson gson = new Gson();
        String json = gson.toJson(locationDataEntity);

        //when & then
        mockMvc.perform(post("/v1/location/addLocationData")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
    }

    @Test
    public void testGetLocationDataById() throws Exception {
        //given
        LocationDataEntity locationDataEntity = new LocationDataEntity(
                1L, "test", "test", "test", new LocationEntity());

        when(locationDataEntityService.addLocationData(any(LocationDataEntity.class))).thenReturn(locationDataEntity);

        when(locationDataEntityService.getLocationDataById(1L)).thenReturn(locationDataEntity);

        //when & then
        mockMvc.perform(get("/v1/location/getLocationData/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.detailedName", is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.iataCode", is("test")));
    }

    @Test
    public void testDeleteLocationDataById() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/location/deleteLocationData/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}