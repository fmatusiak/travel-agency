package com.fmatusiak.travelagency.controller.database.weather;

import com.fmatusiak.travelagency.domain.entity.weather.CityEntity;
import com.fmatusiak.travelagency.domain.entity.weather.DailyForecastEntity;
import com.fmatusiak.travelagency.service.entity.weather.CityEntityService;
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

@WebMvcTest(CityEntityController.class)
@RunWith(SpringRunner.class)
public class CityEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CityEntityService cityEntityService;

    @Test
    public void addCity() throws Exception {
        //given
        CityEntity cityEntity = new CityEntity();

        when(cityEntityService.addCity(any(CityEntity.class))).thenReturn(cityEntity);

        Gson gson = new Gson();
        String json = gson.toJson(cityEntity);

        //when & then
        mockMvc.perform(post("/v1/city/addCity")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
    }

    @Test
    public void getCityById() throws Exception {
        //given
        CityEntity cityEntity = new CityEntity(
                1L,"test","test"
                ,"test","test",new DailyForecastEntity());

        when(cityEntityService.addCity(any(CityEntity.class))).thenReturn(cityEntity);

        when(cityEntityService.getCityById(1L)).thenReturn(cityEntity);

        //when & then
        mockMvc.perform(get("/v1/city/getCity/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.key", is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.localizedName", is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.countryName", is("test")));
    }

    @Test
    public void deleteCityById() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/city/deleteCity/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}