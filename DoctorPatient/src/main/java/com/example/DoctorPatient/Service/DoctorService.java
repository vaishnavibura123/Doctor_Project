package com.example.DoctorPatient.Service;

import com.example.DoctorPatient.Model.Doctor;
import com.example.DoctorPatient.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;

    public void saveDoctor(Doctor doctor) {
         doctorRepo.save(doctor);
    }

    public void deleteDoctor(int doctorId) {
        doctorRepo.deleteById(doctorId);
    }

    public List<Doctor> getAllDoctors() {
       return doctorRepo.findAll();
    }

}
