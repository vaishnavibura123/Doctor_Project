package com.example.DoctorPatient.Service;

import com.example.DoctorPatient.Model.Doctor;
import com.example.DoctorPatient.Model.Patient;
import com.example.DoctorPatient.Repository.DoctorRepo;
import com.example.DoctorPatient.Repository.PatientRepo;
import com.example.DoctorPatient.HelperClass.HelperClass;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorRepo doctorRepo;

    public void addPatient(Patient patient) {
        patientRepo.save(patient);
    }

    public void deletePatient(int patientId) {
        patientRepo.deleteById(patientId);
    }

    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    public String getSuggestedDoctor(int patientId) {
        if(patientRepo.findById(patientId).isEmpty()){
            return "Sorry patient with the Id "+patientId+" is not present in the database";
        }
        Patient patient = patientRepo.findById(patientId).get();
        String symptom = HelperClass.symptoms(patient.getSymptoms().toUpperCase());
        if(HelperClass.city().isEmpty()){
            return "Sorry, We are still waiting to expand to your location";
        }

        if(doctorRepo.findDoctorByDoctorCity(patient.getCity().toUpperCase()).isEmpty()){
            return "Sorry, We are still waiting to expand to your location";
        }
        List<Doctor> byDoctorSpecializedInAndDoctorCity = doctorRepo.findDoctorByDoctorSpecializationAndCity(patient.getCity().toUpperCase(), symptom);
        JSONArray jArray=new JSONArray();
        for(Doctor val:byDoctorSpecializedInAndDoctorCity){
            jArray.put(val);
        }
        if(jArray.length()==0){
            return "Sorry, There isn’t any doctor present at your location for your symptom";
        }
        return jArray.toString();
    }
}
