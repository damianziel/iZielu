package com.sda.iManu.converter;

import com.sda.iManu.domain.Tour;
import com.sda.iManu.dto.TourDto;

/**
 * Created by RENT on 2016-09-28.
 */
public class TourDtoToTourConverter implements IConverter<TourDto, Tour> {

    Tour tour;

    @Override
    public Tour convert(TourDto tourDto) {
        final Tour result = new Tour();

        tour.setType(tourDto.getType());
        tour.setCountry(tourDto.getCountry());
        tour.setDeparturePort(tourDto.getDeparturePort());
        tour.setDate(tourDto.getDate());
        tour.setDuration(tourDto.getDuration());
        tour.setCapacity(tourDto.getCapacity());
        tour.setDescription(tourDto.getDescription());
        tour.setHotel(tourDto.getHotel());
        tour.setPrice(tourDto.getPrice());

        return result;
    }
}
