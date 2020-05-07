package com.lacentrale.fraudmanagement.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Vehicle {
    private String model;

    private String registerNumber;

    private String category;

    private String make;

    private String version;

    private String mileage;
}
