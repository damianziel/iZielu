package com.sda.iManu.converter;

import com.sda.iManu.domain.Tour;
import com.sda.iManu.dto.TourDto;

/**
 * Created by RENT on 2016-09-28.
 */
public class TourDtoToTourConverter implements IConverter <TourDto, Tour> {

    @Override
    public Tour convert(TourDto tourDto) {

        final Tour result = new Tour (
                tourDto.getDate(),
                tourDto.getDuration(),
                tourDto.getCapacity(),
                tourDto.getDescription(),
                tourDto.getHotel(),
                tourDto.getPrice()
        );
        return result;
    }
}
