package com.sda.iManu.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by RENT on 2016-09-21.
 */
@Getter
@Setter
public class Hotel {

    @Id
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String url;


    public Hotel(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }
}
