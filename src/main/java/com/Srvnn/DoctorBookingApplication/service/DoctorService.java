package com.Srvnn.DoctorBookingApplication.service;

import com.Srvnn.DoctorBookingApplication.model.Doctor;
import com.Srvnn.DoctorBookingApplication.model.dto.AuthenticationInputDto;
import com.Srvnn.DoctorBookingApplication.repository.IDoctorRepository;
import com.Srvnn.DoctorBookingApplication.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    IDoctorRepository iDoctorRepository;

    @Autowired
    PTokenService pTokenService;

    // Return all doctors
    public List<Doctor> getAllDoctors(AuthenticationInputDto authenticationInput) {
        if(pTokenService.authenticate(authenticationInput)) {
            return iDoctorRepository.findAll();
        }
        return null;
    }

    // Finds doctor by I'd
    public Doctor getDoctorById(Long docId) {
        return iDoctorRepository.findById(docId).orElseThrow();
    }

    // Add doctor
    public String addDoctor(Doctor doctor) {
        if(!iDoctorRepository.existsById(doctor.getDocId())){
            doctor.setAppointments(null);
            iDoctorRepository.save(doctor);
            return "Doctor added successfully";
        }

        return "Doctor already exists";
    }
}
