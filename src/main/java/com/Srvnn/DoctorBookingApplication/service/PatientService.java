package com.Srvnn.DoctorBookingApplication.service;

import com.Srvnn.DoctorBookingApplication.model.Patient;
import com.Srvnn.DoctorBookingApplication.model.PatientAuthenticationToken;
import com.Srvnn.DoctorBookingApplication.model.dto.AuthenticationInputDto;
import com.Srvnn.DoctorBookingApplication.model.dto.SignInInputDto;
import com.Srvnn.DoctorBookingApplication.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    IPatientRepository iPatientRepository;

    @Autowired
    PTokenService pTokenService;

    // Sign up - new User
    public String patientSignUp(Patient patient) {
        // Check if a user with the same email already exists.
        Patient existingUser = iPatientRepository.findByPatientEmail(patient.getPatientEmail());

        if(existingUser != null) {
            return "Email already registered.Please Sign in. ";
        }

        String password = patient.getPatientPassword();
        try {
            // Encrypt the password and set it in the patient object.
            String encryptedPassword = PasswordEncrypt.encrypt(password);
            patient.setPatientPassword(encryptedPassword);

            // Save the patient to the repository.
            iPatientRepository.save(patient);

            return "Registered Successfully";
        }
        catch (NoSuchAlgorithmException e) {
            return "Internal server error,Please try again later";
        }
    }


    // Sign In - already registered user
    public String patientSignIn(SignInInputDto signInInput) {
        // Get the email from the input.
        String email = signInInput.getEmail();

        // Find the patient using the provided email.
        Patient user = iPatientRepository.findByPatientEmail(email);

        // If the user doesn't exist, return a message to sign up.
        if(user == null) {
            return "Please sign up first";
        }

        // Get the password from the input.
        String password = signInInput.getPassword();
        try {
            // Encrypt the provided password for comparison.
            String encryptedPassword = PasswordEncrypt.encrypt(password);

            // Check if the encrypted password matches the stored password.
            if(user.getPatientPassword().equals(encryptedPassword)) {
                // If the credentials are correct, create an authentication token.
                PatientAuthenticationToken token = new PatientAuthenticationToken(user);
                pTokenService.createToken(token);

                // Send a token to the user's email.
                EmailService.sendMail(email,"Token for Login", token.getTokenValue());

                return "Check your email for Token";
            }
            else {
                return "User credentials are incorrect";
            }
        } catch (NoSuchAlgorithmException e) {
            return "Internal Server error, Please try again later";
        }
    }


    // Patient sign out - only user who signed in can sign out(who has valid token)
    public String patientSignOut(AuthenticationInputDto authenticationInput) {
        // If authentication is true allow to sign out
        if(pTokenService.authenticate(authenticationInput)) {
            String tokenValue = authenticationInput.getTokenValue();
            pTokenService.deleteToken(tokenValue);

            return "Signed out successfully";
        }

        // Otherwise return's Unauthorized request
        else{
            return "Unauthorized request";
        }
    }

    // Returns all patients
    public List<Patient> getAllPatients() {
        return iPatientRepository.findAll();
    }
}
