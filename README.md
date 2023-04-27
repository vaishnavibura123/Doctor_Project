# Doctor_Project
This project is a backend API system for a doctor-patient management system. It is built using the Spring Boot framework and Hibernate for database operations
## Requirements
* 
## Setup
Clone the repository:
git clone https://github.com/vaishnavibura123/Doctor_Project.git
Create a new MySQL database and run the db.sql script to create the required tables.
Edit the application.properties file.
Build and run the application.
The API endpoints can be accessed at "http://localhost:8080/swagger-ui.html".
## API Endpoints
### Doctor APIs
POST /api/v1/doctor/addDoctor: Add a new doctor to the system.
DELETE /api/v1/doctor/deleteDoctor/{doctorId}: Delete an existing doctor from the system.
GET /api/v1/doctor/getAllDoctors : Get a list of all doctors in the system.
### Patient APIs
POST /api/v1/patient/addPatient: Add a new patient to the system.
DELETE /api/v1/patient/deletePatient/{patientId}: Delete an existing patient from the system.
GET /api/v1/patient/getAllPatients: Get a list of all patients in the system.
GET /api/v1/patient/getSuggestedDoctor/{patientId}: uggest a doctor based on the patient's symptom and location.
## Validations
The following validations are implemented for the input fields:
Name: Should be at least 3 characters
City: Should be at max 20 characters
Email: Should be a valid email address
Phone number: Should be at least 10 numbers
## 
This project provides a backend API system for a doctor-patient management system. 
It includes APIs for adding and removing doctors and patients, and suggesting doctors based on the patient's symptom and location.
It also implements validations for input fields and handles edge cases appropriately.
