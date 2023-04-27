package com.example.DoctorPatient.Controller;

import com.example.DoctorPatient.Model.Doctor;
import com.example.DoctorPatient.Repository.DoctorRepo;
import com.example.DoctorPatient.Service.DoctorService;

import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    private DoctorRepo doctorRepo;
    @PostMapping("/addDoctor")
    public ResponseEntity<String> addDoctor(@Valid @RequestBody Doctor doctor){
        JSONObject valid=validDoctor(doctor);
        if(!valid.isEmpty()){
            return new ResponseEntity<>(valid.toString(), HttpStatus.BAD_REQUEST);
        }
       doctorService.saveDoctor(doctor);
        return new ResponseEntity<>("Doctor profile is added successfully with id-"+doctor.getDoctorId(),HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteDoctor/{doctorId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable int doctorId){
        if (!doctorRepo.findById(doctorId).isPresent())
            return new ResponseEntity<>("Doctor with given id is present" + doctorId, HttpStatus.BAD_REQUEST);
        doctorService.deleteDoctor(doctorId);
        return new ResponseEntity<>("Doctor profile is deleted with id-"+doctorId,HttpStatus.OK);
    }
    @GetMapping("/getAllDoctors")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    private JSONObject validDoctor(Doctor doctor) {
        JSONObject errors=new JSONObject();
        String city= doctor.getDoctorCity();
        if(!city.equals("delhi") && !city.equals("faridabad") && !city.equals("noida")){
            errors.put(city,"Doctor location should be from delhi or faridabad or noida");
        }
        String speciality= doctor.getDoctorSpecialization();
        if(!speciality.equals("Orthopedic") && !speciality.equals("Dermatologist") && !speciality.equals("Gynecologist") && !speciality.equals("ENT")){
            errors.put(speciality,"Doctors should be specialized in Orthopedic or Dermatology or Gynecology or ENT");
        }
        return errors;
    }
}
