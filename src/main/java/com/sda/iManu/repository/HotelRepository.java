package com.sda.iManu.repository;

import com.sda.iManu.domain.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by RENT on 2016-09-21.
 */
public interface HotelRepository extends MongoRepository<Hotel, Integer> {

}
