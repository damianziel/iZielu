package com.sda.iManu.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by RENT on 2016-09-21.
 */
@Getter
@Setter
public class HotelDto {

    @NotNull
    private String name;

    @NotNull
    private String url;

    public HotelDto() {
    }
}
