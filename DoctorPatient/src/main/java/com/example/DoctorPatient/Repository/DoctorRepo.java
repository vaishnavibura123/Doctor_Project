package com.example.DoctorPatient.Repository;

import com.example.DoctorPatient.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Integer> {
    @Query(value = "Select * from doctor_tbl where doctor_city=:city", nativeQuery = true)
    public List<Doctor> findDoctorByDoctorCity(String city);
    @Query(value = "Select * from doctor_tbl where doctor_specialization=:symptoms and doctor_city=:city",nativeQuery = true)
    public List<Doctor> findDoctorByDoctorSpecializationAndCity(String city, String symptoms);
}
