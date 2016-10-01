package com.sda.iManu.dto;

import com.sda.iManu.domain.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;


/**
 * Created by RENT on 2016-09-21.
 */
@Getter
@Setter
@EqualsAndHashCode
public class TourDto {

    @Id
    @NotNull
    private int id;

    Type type;

    Country country;

    @NotNull
    private DeparturePort departurePort;

    @DateTimeFormat (pattern="dd-MM-YYYY")
    private String date;

    @NotNull
    private int duration;
    {

    }
    @NotNull
    private int capacity;

    @NotNull
    private String description;

    private String hotel;

    private BigDecimal price;

    public static TourDto fromTour(final Tour tour) {
        final TourDto result = new TourDto();

        result.setDate(tour.getDate());
        result.setCountry(tour.getCountry());
        result.setCapacity(tour.getCapacity());
        result.setDeparturePort(tour.getDeparturePort());
        result.setDescription(tour.getDescription());
        result.setDuration(tour.getDuration());
        result.setHotel(tour.getHotel());
        result.setPrice(tour.getPrice());
        result.setType(tour.getType());

        return result;
    }

}
