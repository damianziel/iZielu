package com.sda.iManu.service;

import com.sda.iManu.domain.Tour;

import java.util.List;

/**
 * Created by RENT on 2016-09-21.
 */
public interface ITourService {

    boolean addTour(Tour tour);
    void deleteTour(int tourId);
    List<Tour> showAllTours(Tour tour);
}
