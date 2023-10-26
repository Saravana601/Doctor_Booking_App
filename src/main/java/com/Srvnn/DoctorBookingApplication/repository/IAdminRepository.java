package com.Srvnn.DoctorBookingApplication.repository;

import com.Srvnn.DoctorBookingApplication.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepository extends JpaRepository<Admin,Long> {
}
