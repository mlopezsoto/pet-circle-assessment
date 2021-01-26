package com.petcircle.carrental.thirdpartylicense.service;

import com.petcircle.carrental.thirdpartylicense.data.LicenseInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LicenseValidationService {

    List<LicenseInfo> validateListOfLicenses(List<Integer> licenseNumberList);
}
