package com.Srvnn.DoctorBookingApplication.controller;

import com.Srvnn.DoctorBookingApplication.model.Doctor;
import com.Srvnn.DoctorBookingApplication.model.Patient;
import com.Srvnn.DoctorBookingApplication.service.DoctorService;
import com.Srvnn.DoctorBookingApplication.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
public class AdminController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    @PostMapping("doctor")
    public String addDoctor(@RequestBody @Valid Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    @GetMapping("patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
}
