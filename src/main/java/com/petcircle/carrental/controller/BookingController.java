package com.petcircle.carrental.controller;

import com.petcircle.carrental.data.Booking;
import com.petcircle.carrental.data.BookingResults;
import com.petcircle.carrental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping(path = "/booking", consumes = "application/json", produces = "application/json")
    public BookingResults newBooking(@RequestBody Booking booking) {
        return bookingService.createNewCarBooking(booking);
    }
}
