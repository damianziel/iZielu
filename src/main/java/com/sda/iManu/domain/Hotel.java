package com.sda.iManu.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by RENT on 2016-09-21.
 */
@Getter
@Setter
@ToString
public class Hotel {

    private String name;

    private String url;

    private Boolean isNew;

    public Hotel() {
    }
}
