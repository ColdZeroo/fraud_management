package com.lacentrale.fraudmanagement.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Contacts {
    private String firstName;

    private String lastName;

    private String email;

    private Phone1 phone1;
}
