package com.sda.iManu.converter;

import com.sda.iManu.domain.Tour;
import com.sda.iManu.dto.TourDto;

/**
 * Created by RENT on 2016-09-28.
 */
public class TourDtoToTourConverter implements IConverter<TourDto, Tour> {

    @Override
    public Tour convert(TourDto tourDto) {
        final Tour result = new Tour();

        result.setType(tourDto.getType());
        result.setCountry(tourDto.getCountry());
        result.setDeparturePort(tourDto.getDeparturePort());
        result.setDate(tourDto.getDate());
        result.setDuration(tourDto.getDuration());
        result.setCapacity(tourDto.getCapacity());
        result.setDescription(tourDto.getDescription());
        result.setHotel(tourDto.getHotel());
        result.setPrice(tourDto.getPrice());

        return result;
    }
}
