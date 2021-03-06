package com.fmatusiak.travelagency.service.entity.hotel;


import com.fmatusiak.travelagency.domain.entity.hotel.HotelPriceEntity;
import com.fmatusiak.travelagency.repository.hotel.HotelPriceEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class HotelPriceEntityService {

    @Autowired
    private HotelPriceEntityRepository hotelPriceEntityRepository;

    public HotelPriceEntity addHotelPrice(HotelPriceEntity hotelPriceEntity) {
        return hotelPriceEntityRepository.save(hotelPriceEntity);
    }

    public HotelPriceEntity getHotelPriceById(Long id) {
        return hotelPriceEntityRepository.findById(id).orElse(null);
    }

    public void deleteHotelPriceById(Long id) {
        hotelPriceEntityRepository.deleteById(id);
    }

}
