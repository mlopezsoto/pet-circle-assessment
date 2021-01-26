package com.petcircle.carrental.data;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Booking {

    private long id;

    private Car car;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private List<Driver> drivers;

}
