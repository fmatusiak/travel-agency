package com.fmatusiak.travelagency.service.entity.weather;

import com.fmatusiak.travelagency.domain.entity.weather.CityEntity;
import com.fmatusiak.travelagency.repository.weather.CityEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class CityEntityService {

    @Autowired
    private CityEntityRepository cityEntityRepository;

    public CityEntity addCity(CityEntity cityEntity) {
        return cityEntityRepository.save(cityEntity);
    }

    public Optional<CityEntity> getCityById(long id) {
        return cityEntityRepository.findById(id);
    }

    public void deleteCityById(long id) {
        cityEntityRepository.deleteById(id);
    }
}
