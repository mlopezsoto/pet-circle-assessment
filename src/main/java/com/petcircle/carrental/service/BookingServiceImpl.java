package com.petcircle.carrental.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petcircle.carrental.data.Booking;
import com.petcircle.carrental.data.BookingResults;
import com.petcircle.carrental.data.LicenseDetails;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Override
    public BookingResults createNewCarBooking(Booking booking) {

        StringBuilder licenseNumbers = new StringBuilder("");
        booking.getDrivers().stream().forEach(driver -> {
            licenseNumbers.append(driver.getLicenseNumber());
            licenseNumbers.append(",");
        });


        List<LicenseDetails> licenseDetailsList =
                getLicenseDetails(licenseNumbers.toString().substring(0, licenseNumbers.length() - 1));

        //Validate License details
        licenseDetailsList.stream().forEach( licenseDetails -> {
                 licenseDetails.isValid();
                licenseDetails.getExpiryDate(); // Validate expiry date against Booking dates
        });

        //IF everything Ok, create Booking, otherwise report error tu user
        BookingResults bookingResults = new BookingResults();
        bookingResults.setBookingCreated(false);
        bookingResults.setErrorMessage("Booking dates are after license expiration date");
        return bookingResults;
    }

    /**
     * Invokes REST Get Service on the ThirdParty Service provider.
     * Using HTTP Client to simulate external system
     * @param licenseNumbers CSV License Numbers
     * @return List of {@link LicenseDetails} with License details for the parameter list
     */
    @SneakyThrows
    private List<LicenseDetails> getLicenseDetails(String licenseNumbers) {
        final ClientConfig clientConfig = new DefaultClientConfig();
        final Client client = Client.create(clientConfig);

        final WebResource webResource = client.resource(UriBuilder.fromUri("http://localhost:8080").build());

        String licenseDetailsString = webResource.path("thirdparty/license/validate").path("10000,10").accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        List<LicenseDetails> licenseDetails = objectMapper.readValue(licenseDetailsString, new TypeReference<List<LicenseDetails>>(){});

        return licenseDetails;
    }
}
