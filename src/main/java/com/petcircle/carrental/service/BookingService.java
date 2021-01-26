package com.petcircle.carrental.service;

import com.petcircle.carrental.data.Booking;
import com.petcircle.carrental.data.BookingResults;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {

    BookingResults createNewCarBooking(Booking booking);
}
