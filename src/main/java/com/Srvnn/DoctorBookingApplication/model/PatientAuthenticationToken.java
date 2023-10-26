package com.Srvnn.DoctorBookingApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PAuthentication")
public class PatientAuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;

    private String tokenValue;

    private LocalDateTime tokenCreationTime;

    @OneToOne
    @JoinColumn(name="fk_patient")
    Patient patient;

    public PatientAuthenticationToken(Patient patient) {
        this.patient = patient;
        this.tokenCreationTime=LocalDateTime.now();
        this.tokenValue= UUID.randomUUID().toString();
    }
}

