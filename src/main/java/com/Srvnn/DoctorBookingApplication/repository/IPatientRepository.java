package com.Srvnn.DoctorBookingApplication.repository;

import com.Srvnn.DoctorBookingApplication.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient,Long> {
    Patient findByPatientEmail(String patientEmail);
}
