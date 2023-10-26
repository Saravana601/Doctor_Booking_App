package com.Srvnn.DoctorBookingApplication.repository;

import com.Srvnn.DoctorBookingApplication.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<Doctor,Long> {
}
