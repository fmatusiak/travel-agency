package com.fmatusiak.travelagency.service.entity.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelContactEntity;
import com.fmatusiak.travelagency.repository.hotel.HotelContactEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class HotelContactEntityService {

    @Autowired
    private HotelContactEntityRepository hotelContactEntityRepository;

    public HotelContactEntity addHotelContact(HotelContactEntity hotelContactEntity) {
        return hotelContactEntityRepository.save(hotelContactEntity);
    }

    public Optional<HotelContactEntity> getHotelContactById(long id) {
        return hotelContactEntityRepository.findById(id);
    }

    public void deleteHotelContactById(long id) {
        hotelContactEntityRepository.deleteById(id);
    }

}
