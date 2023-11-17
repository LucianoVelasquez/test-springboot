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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
@Tag(name = "Countries", description = "the country API")
public class CountryController {

    private final CountryService countryService;

    @Operation(summary = "Buscar por Id",description = "El id son las primeras dos letras del pais que se quiere buscar")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Pais encontrado con exito",
        content = {
            @Content(mediaType = "application/*+json",
            schema = @Schema(implementation = Countries.class)),
        }),
        @ApiResponse(responseCode = "400",description = "Id del pais incorrecto",content = @Content)
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCountry(@Parameter(description = "ejemplo: ar") @PathVariable String id){
        try {

            Countries res = countryService.getCountry("."+id);

            if (res == null) { throw new Exception("Id incorrecto"); }

            return new ResponseEntity<>(res, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }


    @Operation(summary = "Busca por nombre",description = "Busca pais por nombre, tambien busca varios nombres por coincidencia.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Pais encontrado con exito",
        content = {
            @Content(mediaType = "application/*+json",
            schema = @Schema(implementation = Countries.class)),
        }),
        @ApiResponse(responseCode = "400",description = "Nombre incorrecto",content = @Content)
    })
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

    @Operation(hidden = true)
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
