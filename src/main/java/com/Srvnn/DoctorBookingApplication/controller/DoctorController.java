package com.Srvnn.DoctorBookingApplication.controller;

import com.Srvnn.DoctorBookingApplication.model.Doctor;
import com.Srvnn.DoctorBookingApplication.model.dto.AuthenticationInputDto;
import com.Srvnn.DoctorBookingApplication.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("doctors")
    public List<Doctor> getAllDoctors(@RequestBody AuthenticationInputDto authenticationInput) {
        return doctorService.getAllDoctors(authenticationInput);
    }

    @GetMapping("doctor/{docId}")
    public Doctor getDoctorById(@PathVariable Long docId) {
        return doctorService.getDoctorById(docId);
    }
}
