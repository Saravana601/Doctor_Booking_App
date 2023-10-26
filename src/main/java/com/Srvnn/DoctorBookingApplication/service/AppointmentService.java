package com.Srvnn.DoctorBookingApplication.service;

import com.Srvnn.DoctorBookingApplication.model.Appointment;
import com.Srvnn.DoctorBookingApplication.model.Patient;
import com.Srvnn.DoctorBookingApplication.model.dto.AuthenticationInputDto;
import com.Srvnn.DoctorBookingApplication.model.dto.ScheduleAppointmentDto;
import com.Srvnn.DoctorBookingApplication.repository.IAppointmentRepository;
import com.Srvnn.DoctorBookingApplication.repository.IDoctorRepository;
import com.Srvnn.DoctorBookingApplication.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentService {

    @Autowired
    IAppointmentRepository iAppointmentRepository;

    @Autowired
    PTokenService pTokenService;

    @Autowired
    IPatientRepository iPatientRepository;

    @Autowired
    IDoctorRepository iDoctorRepository;

    // Making an Appointment
    public String scheduleAppointment(ScheduleAppointmentDto scheduleAppointmentDto) {
        if(!pTokenService.authenticate(scheduleAppointmentDto.getAuthenticationInput())) {
            return "Sign in to schedule the appointment";
        }

        Appointment appointment = scheduleAppointmentDto.getAppointment();

        String email = scheduleAppointmentDto.getAuthenticationInput().getEmail();

        Patient patient = iPatientRepository.findByPatientEmail(email);

        appointment.setPatient(patient);

        if(iDoctorRepository.existsById(appointment.getDoctor().getDocId())) {
            appointment.setAppCreationTime(LocalDateTime.now());
            iAppointmentRepository.save(appointment);
            return "Appointment booked successfully at " + appointment.getAppCreationTime() + " with Dr." + appointment.getDoctor().getDocName();
        }
        else {
            return "Choose another doctor";
        }
    }

    //Delete appointment
    public String deleteAppointment(AuthenticationInputDto authenticationInput, Long appointmentId) {

        if (!pTokenService.authenticate(authenticationInput)) {
            return "Unauthenticated access";
        }

        String email = authenticationInput.getEmail();

        Patient patient = iPatientRepository.findByPatientEmail(email);
        Appointment existingAppointment = iAppointmentRepository.findById(appointmentId).orElseThrow();

        if (patient.equals(existingAppointment.getPatient())) {
            iAppointmentRepository.deleteById(appointmentId);
            return "Appointment with dr." + existingAppointment.getDoctor().getDocName() + "has been cancelled";
        }
        return "UnAuthorised access";
    }
}
