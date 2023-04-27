package com.example.DoctorPatient.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient_tbl")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    @Column(name = "patient_name")
    @Length(min=3,message = "Please provide minimum of 3 characters for patient name")
    private String patientName;
    @Column(name = "city")
    @Length(max = 20,message = "city name should be below 20 characters")
    private String city;
    @Column(name="email_id")
    @Email(message = "Please provide valid Email Id")
    private String emailId;
    @Column(name ="phone_number")
    @Length(min=10,max = 10, message = "Please provide a valid phone number of 10 digits")
    private String phoneNumber;
    @Column(name = "symptoms")
    private String symptoms;


}
