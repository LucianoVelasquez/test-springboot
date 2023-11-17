package com.cursoJava.cursoJava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoJava.cursoJava.models.Activities;
import com.cursoJava.cursoJava.repository.ActivityRepository;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository dbcontex;

    public Activities createActivity(Activities activities){
        
        return dbcontex.save(activities);
    }

    public List<Activities> getActivities(){
        return dbcontex.findAll();
    }

    public void save(Activities activities){
        dbcontex.save(activities);
    }

}
