# Doctor Booking Application (Spring Boot)

Welcome to the Doctor Booking Application! This Spring Boot application allows patients to book appointments with doctors. It employs token-based authentication for user access. Patients can sign up, sign in, book appointments, and cancel appointments if they have any. Admin users have the privilege to add doctors and access lists of doctors and patients.

## Frameworks and Language Used

- Framework: Spring Boot
- Language: Java

## Data Flow

### Controller
- Handles incoming HTTP requests and manages the flow of data in and out of the application.

- **Admin Controller**:
  - Endpoint: `POST /addDoctor`
    - Description: Add a new doctor (Admin role).
  - Endpoint: `DELETE /doctors/delete/{doctorId}`
    - Description: Delete a specific doctor (Admin role).

- **Doctor Controller**:
  - Endpoint: `GET /doctors`
    - Description: Retrieve a list of all doctors (Doctor role).
  - Endpoint: `GET /doctor/id/{id}`
    - Description: Retrieve doctor data by ID (Doctor role).
  - Endpoint: `GET /doctor/appointments/{doctorId}`
    - Description: Retrieve doctor's scheduled appointments (Doctor role).

- **Patient Controller**:
  - Endpoint: `POST /patient/signUp`
    - Description: Allow a patient to sign up for an account.
  - Endpoint: `POST /patient/signIn`
    - Description: Allow a patient to sign in after signing up and receive a token.
  - Endpoint: `DELETE /patient/signOut`
    - Description: Allow a patient to sign out.
  - Endpoint: `POST /patient/appointment/schedule`
    - Description: Allow patients to schedule appointments.
  - Endpoint: `DELETE /patient/appointment/cancel/{appointmentId}`
    - Description: Cancel an appointment by its ID.

### Services

- **Appointment Service**:
  - Responsible for managing appointments, including scheduling, cancellation, and data retrieval.

- **Doctor Service**:
  - Manages doctor-related operations, such as adding doctors and complex doctor-specific business logic.

- **Email Service**:
  - Handles email-related functions, facilitating communication between the application and users.

- **Password Encrypt Service**:
  - Ensures secure storage of user passwords in the database through encryption and hashing techniques.

- **Patient Service**:
  - Manages patient operations, including registration, sign-in, and patient-specific functionalities.

- **Patient Token Service**:
  - Specialized in managing tokens for patient authentication, including creation, validation, and security measures.

### Repository

- **Admin Repository**:
  - Defines methods for admin user data storage and retrieval, typically including admin user addition and data access.

- **Appointment Repository**:
  - Manages appointment data in the database, including storage and retrieval of details such as date, time, patient, and doctor.

- **Doctor Repository**:
  - Manages doctor-related data, providing methods for efficient doctor information storage and retrieval.

- **Patient Repository**:
  - Handles patient-related data in the database, including user registration, data retrieval, and other patient-specific operations.

- **Patient Token Repository**:
  - Manages tokens associated with patient authentication, ensuring secure user access through token data storage and retrieval.

## Project Summary
This Spring Boot application serves as a backend for the Doctor Booking Application. It provides RESTful API endpoints for user registration, authentication, doctor management, and patient appointments. The application is secure, efficient, and extensible.


## Contact

If you have any questions or suggestions, feel free to contact me at the following
- [Gmail](saravanad2401@gmail.com).
- [LinkedIn](https://www.linkedin.com/in/saravanad2401/).
