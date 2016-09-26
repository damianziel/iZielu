package com.sda.iManu.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * Created by RENT on 2016-09-21.
 */
@Getter
@Setter

public class Reservation {
    public Reservation(String tourId, String userId, float price) {
        this.tourId = tourId;
        this.userId = userId;
        this.price = price;
    }

    @lombok.Getter
    @lombok.Setter
    private String tourId;

    @lombok.Getter
    @lombok.Setter
    private String userId;

    @lombok.Getter
    @lombok.Setter
    private float price;
}
