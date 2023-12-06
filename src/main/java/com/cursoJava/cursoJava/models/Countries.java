package com.cursoJava.cursoJava.models;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "countriesactivities" , joinColumns = @JoinColumn(name = "countryId", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "acitivityId", referencedColumnName = "id")
    )
    @JsonIgnore
    List<Activities> activities;
    
}
