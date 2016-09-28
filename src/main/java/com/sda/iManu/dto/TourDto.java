package com.sda.iManu.dto;

import com.sda.iManu.domain.Country;
import com.sda.iManu.domain.Hotel;
import com.sda.iManu.domain.Type;
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

    Type type;

    Country country;

    @Id
    @NotNull
    private int id;

    @NotNull
    private String departurePort;

    @DateTimeFormat (pattern="dd-MM-YYYY")
    private Date date;

    @NotNull
    private int duration;

    @NotNull
    private int capacity;

    @NotNull
    private String description;

    private Hotel hotel;

    private BigDecimal price;

    @NotNull
    public TourDto() {
    }
}
