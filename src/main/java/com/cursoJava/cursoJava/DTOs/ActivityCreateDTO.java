package com.cursoJava.cursoJava.DTOs;

import java.util.List;

import com.cursoJava.cursoJava.models.Countries;

import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class ActivityCreateDTO {
    Long id;
    String nombre;
    Integer dificultad;
    Integer duracion;
    String temporada;  
    List<Long> idsCountryes;
}
