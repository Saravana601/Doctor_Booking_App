package com.Srvnn.DoctorBookingApplication.repository;

import com.Srvnn.DoctorBookingApplication.model.PatientAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPTokenRepository extends JpaRepository<PatientAuthenticationToken,Long> {
    PatientAuthenticationToken findByTokenValue(String tokenValue);
}
