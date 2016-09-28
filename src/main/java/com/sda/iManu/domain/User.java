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

    private boolean isAdmin;

    private String email;

    private String firstName;

    private String lastName;

    private Boolean isNew() {
        return getId() != null;
    }

    public User(final String firstName, final String lastName, final String login, final String password, final String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
    }
}
