package com.fmatusiak.travelagency.service.entity.hotel;

import com.fmatusiak.travelagency.domain.entity.hotel.HotelAddressEntity;
import com.fmatusiak.travelagency.repository.hotel.HotelAddressEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class HotelAddressEntityService {

    @Autowired
    private HotelAddressEntityRepository hotelAddressEntityRepository;

    public HotelAddressEntity addHotelAddress(HotelAddressEntity hotelAddressEntity) {
        return hotelAddressEntityRepository.save(hotelAddressEntity);
    }

    public HotelAddressEntity getHotelAddressById(Long id) {
        return hotelAddressEntityRepository.findById(id).orElse(null);
    }

    public void deleteHotelAddressById(Long id) {
        hotelAddressEntityRepository.deleteById(id);
    }

}
