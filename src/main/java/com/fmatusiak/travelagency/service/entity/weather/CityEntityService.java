package com.fmatusiak.travelagency.service.entity.weather;

import com.fmatusiak.travelagency.domain.entity.weather.CityEntity;
import com.fmatusiak.travelagency.repository.weather.CityEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class CityEntityService {

    @Autowired
    private CityEntityRepository cityEntityRepository;

    public CityEntity addCity(CityEntity cityEntity) {
        return cityEntityRepository.save(cityEntity);
    }

    public CityEntity getCityById(Long id) {
        return cityEntityRepository.findById(id).orElse(null);
    }

    public void deleteCityById(Long id) {
        cityEntityRepository.deleteById(id);
    }
}
