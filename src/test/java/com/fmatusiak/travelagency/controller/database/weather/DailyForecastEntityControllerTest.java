package com.fmatusiak.travelagency.controller.database.weather;

import com.fmatusiak.travelagency.domain.entity.weather.CityEntity;
import com.fmatusiak.travelagency.domain.entity.weather.DailyForecastEntity;
import com.fmatusiak.travelagency.service.entity.weather.DailyForecastEntityService;
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

@WebMvcTest(DailyForecastEntityController.class)
@RunWith(SpringRunner.class)
public class DailyForecastEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DailyForecastEntityService dailyForecastEntityService;

    @Test
    public void addDailyforecast() throws Exception {
        //given
        DailyForecastEntity dailyForecastEntity = new DailyForecastEntity();

        when(dailyForecastEntityService.addDailyforecast
                (any(DailyForecastEntity.class)))
                .thenReturn(dailyForecastEntity);

        Gson gson = new Gson();
        String json = gson.toJson(dailyForecastEntity);

        //when & then
        mockMvc.perform(post("/v1/dailyForecast/addDailyForecast")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
    }

    @Test
    public void getDailyforecastById() throws Exception {
        //given
        DailyForecastEntity dailyForecastEntity = new DailyForecastEntity
                (1L, "2019-10-06", 18.00, 25.00, "test", new CityEntity());

        when(dailyForecastEntityService.addDailyforecast
                (any(DailyForecastEntity.class)))
                .thenReturn(dailyForecastEntity);

        when(dailyForecastEntityService.getDailyforecastById(1L)).thenReturn(dailyForecastEntity);

        //when & then
        mockMvc.perform(get("/v1/dailyForecast/getDailyForecast/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.date", is("2019-10-06")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.minimumTemperature", is(18.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.maximumTemperature", is(25.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.unit", is("test")));
    }

    @Test
    public void deleteDailyforecastById() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/dailyForecast/deleteDailyForecast/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}