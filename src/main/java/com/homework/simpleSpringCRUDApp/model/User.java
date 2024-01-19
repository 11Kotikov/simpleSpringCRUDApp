package com.homework.simpleSpringCRUDApp.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
public class User {
    private int id;
    private String firstName;
    private String lastName;
}

