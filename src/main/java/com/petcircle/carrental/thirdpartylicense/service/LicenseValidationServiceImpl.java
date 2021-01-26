package com.petcircle.carrental.thirdpartylicense.service;

import com.petcircle.carrental.thirdpartylicense.data.LicenseInfo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Stub Impl for Testing
 */
@Service
public class LicenseValidationServiceImpl implements LicenseValidationService {

    @Override
    public List<LicenseInfo> validateListOfLicenses(List<Integer> licenseNumberList) {
        List<LicenseInfo> licenseInfoList = new ArrayList<>();

        licenseNumberList.forEach(licenseNumber -> {
            LicenseInfo licenseInfo = new LicenseInfo();
            licenseInfo.setNumber(licenseNumber);
            if (licenseNumber > 1000) {
                licenseInfo.setValid(true);
                licenseInfo.setExpiryDate(LocalDate.parse("2025-12-12"));
                licenseInfo.setType(1);
            } else {
                licenseInfo.setValid(false);
                licenseInfo.setType(0);
            }
            licenseInfoList.add(licenseInfo);
        });

        return  licenseInfoList;
    }
}
