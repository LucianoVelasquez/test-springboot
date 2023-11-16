package com.cursoJava.cursoJava.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Countries{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String tld;
    String name;
    String capital;
    String region;
    String subregion;
    Double area;
    Integer population;
    String continents;
    String flags;

}
