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
@Table(name = "doctor_tbl")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int doctorId;
    @Column(name = "doctor_name")
    private String doctorName;
    @Column(name = "doctor_city")
    private String doctorCity;
    @Email(message = "please provide valid email")
    @Column(name = "doctor_email")
    private String doctorEmail;
    @Length(min=10, max = 10,message = "Phone number should be 10 digits. Please provide valid phone number")
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "doctor_specialization")
    private String doctorSpecialization;
}
