package com.cursoJava.cursoJava.models;



import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data
public class Activities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    String nombre;
    Integer dificultad;
    Integer duracion;
    String temporada; 

    @ManyToMany(mappedBy = "activities")   
    List<Countries> countries;
   
}
