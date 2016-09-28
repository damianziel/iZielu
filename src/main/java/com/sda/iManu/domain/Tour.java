package com.sda.iManu.domain;

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

    private String departurePort;

    private Date date;

    private int duration;

    private int capacity;

    private String description;

    private Hotel hotel;

    private BigDecimal price;

    private Boolean isNew;

    public Tour(final Date date, final int duration, final int capacity, final String description, Hotel hotel, final BigDecimal price) {
        this.date = date;
        this.duration = duration;
        this.capacity = capacity;
        this.description = description;
        this.hotel = hotel;
        this.price = price;
    }
}
