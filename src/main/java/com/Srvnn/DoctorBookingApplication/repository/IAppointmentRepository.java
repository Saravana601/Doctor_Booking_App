package com.Srvnn.DoctorBookingApplication.repository;

import com.Srvnn.DoctorBookingApplication.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment,Long> {
}
