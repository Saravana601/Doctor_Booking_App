package com.Srvnn.DoctorBookingApplication.controller;

import com.Srvnn.DoctorBookingApplication.model.Patient;
import com.Srvnn.DoctorBookingApplication.model.dto.AuthenticationInputDto;
import com.Srvnn.DoctorBookingApplication.model.dto.ScheduleAppointmentDto;
import com.Srvnn.DoctorBookingApplication.model.dto.SignInInputDto;
import com.Srvnn.DoctorBookingApplication.service.AppointmentService;
import com.Srvnn.DoctorBookingApplication.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("signUp")
    public String patientSignUp(@RequestBody @Valid Patient patient){
        return patientService.patientSignUp(patient);
    }

    @PostMapping("signIn")
    public String patientSignIn(@RequestBody SignInInputDto signInInput){
        return patientService.patientSignIn(signInInput);
    }

    @DeleteMapping("signOut")
    public String patientSignOut(@RequestBody AuthenticationInputDto authenticationInput) {
        return patientService.patientSignOut(authenticationInput);
    }

    @PostMapping("appointment")
    public String bookAnAppointment(@RequestBody ScheduleAppointmentDto scheduleAppointmentDto) {
        return appointmentService.scheduleAppointment(scheduleAppointmentDto);
    }

    @DeleteMapping("appointment/{appointmentId}")
    public String deleteAnAppointment(@RequestBody AuthenticationInputDto authenticationInput, @PathVariable Long appointmentId) {
        return appointmentService.deleteAppointment(authenticationInput,appointmentId);
    }

}
