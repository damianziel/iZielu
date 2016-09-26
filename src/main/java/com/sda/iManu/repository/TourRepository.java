package com.sda.iManu.repository;

import com.sda.iManu.domain.Tour;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by RENT on 2016-09-21.
 */
@Repository
public interface TourRepository extends MongoRepository<Tour, String> {

    Tour findByType(String type);
    Tour findByCountries(String countries);
    Tour findByTourLength(int length);
    Tour findByDate(Date date);
    Tour findByPrice(float price);

}
