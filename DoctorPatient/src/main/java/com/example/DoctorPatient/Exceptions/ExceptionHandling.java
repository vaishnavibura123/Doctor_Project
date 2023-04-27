package com.example.DoctorPatient.Exceptions;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> exceptionHandler(MethodArgumentNotValidException exception){
        Map<String,String > map=new HashMap<>();
        BindingResult bindingResult = exception.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError error: allErrors) {
            String code = error.getCode();
            String defaultMessage = error.getDefaultMessage();
            map.put(code,defaultMessage);
        }
        return map;
    }

}
