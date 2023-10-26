package com.Srvnn.DoctorBookingApplication.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.Srvnn.DoctorBookingApplication.model.enums.Qualification;
import com.Srvnn.DoctorBookingApplication.model.enums.Specialization;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Doctor.class,property = "docId")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docId;

    private String docName;

    private Double docFees;

    @Enumerated(value = EnumType.STRING)
    private Qualification docQualification;

    @Enumerated(value = EnumType.STRING)
    private Specialization docSpecialization;

    private String docContact;

    @OneToMany(mappedBy = "doctor")
    List<Appointment> appointments;
}
