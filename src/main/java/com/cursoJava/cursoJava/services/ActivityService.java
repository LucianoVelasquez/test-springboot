package com.cursoJava.cursoJava.services;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoJava.cursoJava.models.Activities;
import com.cursoJava.cursoJava.models.Countries;
import com.cursoJava.cursoJava.repository.ActivityRepository;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository dbcontex;

    @Autowired
    CountryService countryService;

    public Activities createActivity(Activities activities){
        
        return dbcontex.save(activities);
    }

    public List<Activities> getActivities(){
        return dbcontex.findAll();
    }

    public void deleteActivity(Long id){
        dbcontex.deleteById(id);
    }

    public void save(Activities activities){
        dbcontex.save(activities);
    }


}
