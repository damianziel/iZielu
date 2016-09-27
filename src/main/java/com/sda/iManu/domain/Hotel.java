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

    private boolean isNew;

    public Hotel() {
    }
}
