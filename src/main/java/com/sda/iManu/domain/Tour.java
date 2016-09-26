package com.sda.iManu.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by RENT on 2016-09-21.
 */
@Getter
@Setter
@EqualsAndHashCode
public class Tour {

    Type type;
    Countries countries;

    @Id
    private int id;

    private String departurePort;

    private Date date;

    private int tourLength;

    private int capacity;

    private String description;

    private Hotel hotel;

    private float price;

    public Tour(Type type, Countries countries, int id, String departurePort, Date date, int tourLength, int capacity, String description, Hotel hotel, float price) {
        this.type = type;
        this.countries = countries;
        this.id = id;
        this.departurePort = departurePort;
        this.date = date;
        this.tourLength = tourLength;
        this.capacity = capacity;
        this.description = description;
        this.hotel = hotel;
        this.price = price;
    }
}
