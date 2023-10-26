package com.Srvnn.DoctorBookingApplication.service;

import com.Srvnn.DoctorBookingApplication.model.PatientAuthenticationToken;
import com.Srvnn.DoctorBookingApplication.model.dto.AuthenticationInputDto;
import com.Srvnn.DoctorBookingApplication.repository.IPTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PTokenService {

    @Autowired
    IPTokenRepository ipTokenRepository;


    // save the token to database
    public void createToken(PatientAuthenticationToken token) {
     ipTokenRepository.save(token);
    }

    // This method is responsible for authenticating a user based on the provided email and token value.
    public  boolean authenticate(AuthenticationInputDto authenticationInput) {
        String providedEmail = authenticationInput.getEmail();
        String providedTokenValue = authenticationInput.getTokenValue();

        // Retrieve the patient authentication token associated with the provided token value.
        PatientAuthenticationToken authenticationToken = ipTokenRepository.findByTokenValue(providedTokenValue);

        return authenticationToken != null && authenticationToken.getPatient().getPatientEmail().equals(providedEmail);
    }

    // delete the token
    public void deleteToken(String tokenValue) {
        PatientAuthenticationToken authenticationToken = ipTokenRepository.findByTokenValue(tokenValue);
        ipTokenRepository.delete(authenticationToken);
    }
}
