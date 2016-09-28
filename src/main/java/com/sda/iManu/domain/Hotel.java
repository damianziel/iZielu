package com.sda.iManu.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by RENT on 2016-09-21.
 */
@Getter
@Setter
public class Hotel {

    private String name;

    private String url;

    private Boolean isNew;

    @Override
    public String toString() {
        return name.toUpperCase();
    }

    public Hotel() {
    }
}
