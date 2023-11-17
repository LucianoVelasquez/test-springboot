package com.cursoJava.cursoJava.controllers;


import java.util.List;



import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.cursoJava.cursoJava.models.Countries;
import com.cursoJava.cursoJava.services.CountryService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCountry(@PathVariable String id){
        try {

            Countries res = countryService.getCountry("."+id);

            if (res == null) { throw new Exception("Id incorrecto"); }

            return new ResponseEntity<>(res, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping
    public ResponseEntity<?> getCountries(@RequestParam String name) {
        try {

            if(name == ""){ throw new Exception("name no puede ser vacio");}

            List<Countries> res = countryService.getCountries(name);

            if(res.isEmpty()){ throw new Exception("Nombre incorrecto"); }

            return new ResponseEntity<>(res,HttpStatus.OK);

        } catch (Exception e) {
            
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "loadingdata")
    public ResponseEntity<?> cargarDatos() {
        try {

            List<Countries> res = countryService.cargarDatos();

            return new ResponseEntity<>(res,HttpStatus.OK);

        } catch (Exception e) {
            
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
