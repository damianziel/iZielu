package com.sda.iManu.service.impl;

import com.sda.iManu.domain.Hotel;
import com.sda.iManu.repository.HotelRepository;
import com.sda.iManu.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by RENT on 2016-09-21.
 */
@Service
@Scope("session")
public class HotelService implements IHotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public boolean addHotel(Hotel hotel) {
        return hotelRepository.save(hotel) != null;
    }

    @Override
    public void deleteHotel(int hotelId) {
        hotelRepository.delete(hotelId);
    }

}
