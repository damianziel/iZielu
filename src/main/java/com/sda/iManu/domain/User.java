package com.sda.iManu.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Represents customer data.
 */
@Setter
@Getter
@ToString
public class User {

    @Id
    private String id;

    private String login;

    private String password;

    private boolean isAdmin;

    private String email;

    private String firstName;

    private String lastName;

    private String telephone;

    private Boolean isNew;

    public User() {
    }
}
