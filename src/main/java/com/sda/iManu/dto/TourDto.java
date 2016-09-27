package com.sda.iManu.dto;

import com.sda.iManu.domain.Country;
import com.sda.iManu.domain.Hotel;
import com.sda.iManu.domain.Type;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


/**
 * Created by RENT on 2016-09-21.
 */
@Getter
@Setter
@EqualsAndHashCode
public class TourDto {

    Type type;

    Country country;

    @Id
    private int id;

    private String departurePort;

    @DateTimeFormat (pattern="dd-MM-YYYY")
    private Date date;

    private int duration;

    private int capacity;

    private String description;

    private Hotel hotel;

    private BigDecimal price;

    private Boolean isNew;

    public TourDto() {
    }
}
