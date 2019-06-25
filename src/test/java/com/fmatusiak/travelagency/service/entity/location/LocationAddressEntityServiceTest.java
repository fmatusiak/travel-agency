package com.fmatusiak.travelagency.service.entity.location;

import com.fmatusiak.travelagency.domain.entity.location.LocationAddressEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationAddressEntityServiceTest {

    @Autowired
    private LocationAddressEntityService locationAddressEntityService;

    @Test
    public void testAddandGetLocationAddress() {
        //given
        LocationAddressEntity locationAddressEntity = new LocationAddressEntity();
        locationAddressEntityService.addLocationAddress(locationAddressEntity);

        //when
        LocationAddressEntity readLocationAddressEntity = locationAddressEntityService.getLocationAddressById(1L);

        //then
        assertNotNull(readLocationAddressEntity);

    }
}