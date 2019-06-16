package com.fmatusiak.travelagency.service.entity.hotel;


import com.fmatusiak.travelagency.domain.entity.hotel.HotelPriceEntity;
import com.fmatusiak.travelagency.repository.hotel.HotelPriceEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class HotelPriceEntityService {

    @Autowired
    private HotelPriceEntityRepository hotelPriceEntityRepository;

    public HotelPriceEntity addHotelPrice(HotelPriceEntity hotelPriceEntity) {
        return hotelPriceEntityRepository.save(hotelPriceEntity);
    }

    public Optional<HotelPriceEntity> getHotelPriceById(long id) {
        return hotelPriceEntityRepository.findById(id);
    }

    public void deleteHotelPriceById(long id) {
        hotelPriceEntityRepository.deleteById(id);
    }

}
