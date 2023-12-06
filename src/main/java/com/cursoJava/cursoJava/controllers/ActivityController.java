package com.cursoJava.cursoJava.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoJava.cursoJava.DTOs.ActivityCreateDTO;
import com.cursoJava.cursoJava.models.Activities;
import com.cursoJava.cursoJava.models.Countries;
import com.cursoJava.cursoJava.services.ActivityService;
import com.cursoJava.cursoJava.services.CountryService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/activities")
@AllArgsConstructor
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @Autowired
    CountryService countryService;

    @GetMapping
    public ResponseEntity<?> getActivities() {
        try {

            List<Activities> res = activityService.getActivities();

            if(res.isEmpty()){ throw new Exception("No hay actividades disponibles"); }

            return new ResponseEntity<>(res,HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

        } 
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/create")
    public ResponseEntity<?> creatActivities(@RequestBody ActivityCreateDTO activity) {
        try {

            for (Long countryId : activity.getIdsCountryes()) {

                Countries country = countryService.getCountryById(countryId);

                if(country == null) { throw new Exception("Uno de los Id no existe");}
        
            }

            Activities newActivity = new Activities();
                newActivity.setDificultad(activity.getDificultad());
                newActivity.setDuracion(activity.getDuracion());
                newActivity.setNombre(activity.getNombre());
                newActivity.setTemporada(activity.getTemporada());
            activityService.createActivity(newActivity);

            for (Integer i = 0; i < activity.getIdsCountryes().size();i++) {
                Countries newCountry = countryService.getCountryById(activity.getIdsCountryes().get(i));
                List<Activities> nActivities = new ArrayList<>();
                nActivities.add(newActivity);
                newCountry.setActivities(nActivities);
                countryService.save(newCountry);  
            }
            
            return new ResponseEntity<>("Creacion correcta",HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST); 

        }
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable Long id){
        try {

            if(id == null){
                throw new Exception("El id no tiene que estar vacio");
            }

            activityService.deleteActivity(id);

            return new ResponseEntity<>("Actividad con id: "+id+" eliminada",HttpStatus.OK);
            
        } catch (Exception e) {
            
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
