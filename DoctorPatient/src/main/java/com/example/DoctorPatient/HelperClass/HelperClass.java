package com.example.DoctorPatient.HelperClass;

import java.util.ArrayList;
import java.util.List;

public class HelperClass {
    public static List<String> city=new ArrayList<>();

   
    static public List<String> city(){
        city.add("DELHI");
        city.add("FARIDABAD");
        city.add("NOIDA");
        return city;
    }
    public static String symptoms(String symptoms) {
        String result = switch (symptoms) {
            case " ARTHRITIS","BACK PAIN", "TISSUE INJURIES"-> "ORTHOPEDIC";
            case "DYSMENORRHEA"->"GYNECOLOGY";
            case "SKIN BURN","SKIN INFECTION"->"DERMATOLOGY";
            case "EAR PAIN"->"ENT";
            default -> "";
        };
        return result;
    }

}
