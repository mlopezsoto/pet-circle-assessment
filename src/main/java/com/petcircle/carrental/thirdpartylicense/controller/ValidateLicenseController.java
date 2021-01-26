package com.petcircle.carrental.thirdpartylicense.controller;

import com.petcircle.carrental.thirdpartylicense.data.LicenseInfo;
import com.petcircle.carrental.thirdpartylicense.service.LicenseValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ValidateLicenseController {

    @Autowired
    private LicenseValidationService licenseValidationService;

    @GetMapping("/thirdparty/license/validate/{licenseNumbersCsv}")
    public List<LicenseInfo> validateLicenseNumbers(@PathVariable String licenseNumbersCsv) {
        List<Integer> licenseNumbers = Arrays.asList(licenseNumbersCsv.split(",")).stream()
                .map(stringLicenseNumber -> Integer.parseInt(stringLicenseNumber))
                .collect(Collectors.toList());

        return licenseValidationService.validateListOfLicenses(licenseNumbers);
    }
}
