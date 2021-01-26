package com.petcircle.carrental.thirdpartylicense.data;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LicenseInfo {

    private int number;

    private boolean valid;

    private LocalDate expiryDate;

    private int type;
}
