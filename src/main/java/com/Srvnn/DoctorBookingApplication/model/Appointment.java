package com.Srvnn.DoctorBookingApplication.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Appointment.class,property = "appointmentId")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    private String appointmentDesc;

    LocalDateTime appCreationTime;

    LocalDateTime appScheduleTime;

    @ManyToOne
    @JoinColumn(name="patient_fk")
    Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_fk")
    Doctor doctor;
}
