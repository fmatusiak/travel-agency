package com.fmatusiak.travelagency.service.entity.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelPropertyEntity;
import com.fmatusiak.travelagency.repository.hotel.HotelPropertyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class HotelPropertyEntityService {

    @Autowired
    private HotelPropertyEntityRepository hotelPropertyEntityRepository;

    public HotelPropertyEntity addHotelProperty(HotelPropertyEntity hotelPropertyEntity) {
        return hotelPropertyEntityRepository.save(hotelPropertyEntity);
    }

    public HotelPropertyEntity getHotelPropertyById(long id) {
        return hotelPropertyEntityRepository.findById(id).orElse(null);
    }

    public void deleteHotelPropertyById(long id) {
        hotelPropertyEntityRepository.deleteById(id);
    }

}
