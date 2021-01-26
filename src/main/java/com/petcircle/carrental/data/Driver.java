package com.petcircle.carrental.data;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Driver {
    private long id;

    private String name;

    private int licenseNumber;

    private LocalDate expiryDate;

    private boolean validated;
}
