package com.fmatusiak.travelagency.service.entity.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelEntity;
import com.fmatusiak.travelagency.repository.hotel.HotelEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class HotelEntityService {

    @Autowired
    private HotelEntityRepository hotelEntityRepository;

    public HotelEntity addHotel(HotelEntity hotelEntity) {
        return hotelEntityRepository.save(hotelEntity);
    }

    public HotelEntity getHotelById(long id) {
        return hotelEntityRepository.findById(id).orElse(null);
    }

    public void deleteHotelById(long id) {
        hotelEntityRepository.deleteById(id);
    }
}
