package com.cursoJava.cursoJava.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoJava.cursoJava.models.Usuario;

@RestController
public class UsuarioController {

    
    @RequestMapping(value = "usuario/{id}")
    public Usuario GetUsuario(@PathVariable Integer id){
        Usuario newUsuario = new Usuario();
        newUsuario.setId(id);
        newUsuario.setApellido("Velasquez");
        newUsuario.setEmail("Email@.com");
        newUsuario.setName("Luciano");
        newUsuario.setPassword("Password23");

        return newUsuario;
    }


}
