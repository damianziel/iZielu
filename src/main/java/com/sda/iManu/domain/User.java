package com.sda.iManu.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;

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

    private String role;

    private String email;

    private String firstName;

    private String lastName;

    private Boolean isNew() {
        return getId() != null;
    }

    public User() {
    }
}
