package com.petcircle.carrental.data;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class LicenseDetails {

    private int number;

    private boolean valid;

    private Date expiryDate;

    private int type;
}
