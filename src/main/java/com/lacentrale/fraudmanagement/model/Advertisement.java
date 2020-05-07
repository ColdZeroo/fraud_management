package com.lacentrale.fraudmanagement.model;

import lombok.*;

import java.util.Optional;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Advertisement {
    private Optional<Contacts> contacts;

    private String creationDate;

    private double price;

    private String[] publicationOptions;

    private String reference;

    private Optional<Vehicle> vehicle;
}
