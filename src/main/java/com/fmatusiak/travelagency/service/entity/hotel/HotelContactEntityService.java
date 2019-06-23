package com.fmatusiak.travelagency.service.entity.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelContactEntity;
import com.fmatusiak.travelagency.repository.hotel.HotelContactEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class HotelContactEntityService {

    @Autowired
    private HotelContactEntityRepository hotelContactEntityRepository;

    public HotelContactEntity addHotelContact(HotelContactEntity hotelContactEntity) {
        return hotelContactEntityRepository.save(hotelContactEntity);
    }

    public HotelContactEntity getHotelContactById(Long id) {
        return hotelContactEntityRepository.findById(id).orElse(null);
    }

    public void deleteHotelContactById(Long id) {
        hotelContactEntityRepository.deleteById(id);
    }

}
