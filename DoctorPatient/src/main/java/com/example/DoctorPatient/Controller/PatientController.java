package com.example.DoctorPatient.Controller;

import com.example.DoctorPatient.Model.Patient;
import com.example.DoctorPatient.Repository.PatientRepo;
import com.example.DoctorPatient.Service.PatientService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @Autowired
    private PatientRepo patientRepo;
    @PostMapping("/addPatient")
    public ResponseEntity<String> addPatient(@Valid @RequestBody Patient patient){
        JSONObject valid=validatePatient(patient);
        if(valid.isEmpty()){
            patientService.addPatient(patient);
            return new ResponseEntity<>("Patient is added successfully with id-"+patient.getPatientId(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(valid.toString(),HttpStatus.BAD_REQUEST);
    }

    private JSONObject validatePatient(Patient patient) {
        JSONObject errors=new JSONObject();
        String city= patient.getCity();
        if(!city.equals("delhi") && !city.equals("faridabad") && !city.equals("noida")){
            errors.put(city,"We are still waiting to expand your location");
        }
        return errors;
    }
    @GetMapping("/getSuggestedDoctor/{patientId}")
    public ResponseEntity<String> getSuggestedDoctor(@PathVariable int patientId){
        String suggested=patientService.getSuggestedDoctor(patientId);
        if(suggested.contains("Sorry")){
            return new ResponseEntity<>(suggested,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(suggested,HttpStatus.FOUND);
    }
    @DeleteMapping("/deletePatient/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable int patientId){
        if(!patientRepo.findById(patientId).isPresent()){
            return new ResponseEntity<>("patientId which you are trying to delete is not present in database",HttpStatus.BAD_REQUEST);
        }
        patientService.deletePatient(patientId);
        return new ResponseEntity<>("Patient is deleted successfully patientId"+patientId, HttpStatus.OK);
    }
    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }
}
