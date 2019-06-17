package com.fmatusiak.travelagency.service.entity.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelEntity;
import com.fmatusiak.travelagency.repository.hotel.HotelEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class HotelEntityService {

    @Autowired
    private HotelEntityRepository hotelEntityRepository;

    public HotelEntity addHotel(HotelEntity hotelEntity) {
        return hotelEntityRepository.save(hotelEntity);
    }

    public Optional<HotelEntity> getHotelById(long id) {
        return hotelEntityRepository.findById(id);
    }

    public void deleteHotelById(long id) {
        hotelEntityRepository.deleteById(id);
    }
}
