package com.Srvnn.DoctorBookingApplication.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.Srvnn.DoctorBookingApplication.model.Appointment;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleAppointmentDto {
    AuthenticationInputDto authenticationInput;

    Appointment appointment;
}