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

    @NotNull
    @Min(5)
    @Max(12)
    @Indexed(unique = true)
    private String login;

    @NotNull
    @Min(5)
    @Max(12)
    private String password;

    private boolean isAdmin;

    @NotNull
    private String email;

    @NotNull
    @Min(2)
    private String firstName;

    @NotNull
    @Min(2)
    private String lastName;

    private String telephone;

    private Boolean isNew;

    public User() {
    }
}
