package com.sda.iManu.domain;

import com.sda.iManu.dto.TourDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.TemporalType.DATE;


/**
 * Created by RENT on 2016-09-21.
 */
@Getter
@Setter
@EqualsAndHashCode
public class Tour {

    Type type;

    Country country;

    private DeparturePort departurePort;

    private String date;

    private int duration;

    private int capacity;

    private String description;

    private String hotel;

    private BigDecimal price;

    private Boolean isNew;

    public static Tour fromTourDto(final TourDto tourDto) {
        final Tour result = new Tour();

        result.setDate(tourDto.getDate());
        result.setCountry(tourDto.getCountry());
        result.setCapacity(tourDto.getCapacity());
        result.setDeparturePort(tourDto.getDeparturePort());
        result.setDescription(tourDto.getDescription());
        result.setDuration(tourDto.getDuration());
        result.setHotel(tourDto.getHotel());
        result.setPrice(tourDto.getPrice());
        result.setType(tourDto.getType());

        return result;
    }

    public Tour() {
    }
}
