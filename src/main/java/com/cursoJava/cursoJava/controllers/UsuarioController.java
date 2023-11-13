package com.cursoJava.cursoJava.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursoJava.cursoJava.dao.usuarioDao;
import com.cursoJava.cursoJava.models.Usuario;

@RestController
@RequestMapping(value = "api")
public class UsuarioController {

    @Autowired //Inyeccion de dependencia.
    private usuarioDao usuarioDao;

    @RequestMapping(value = "usuarios/{id}",method = RequestMethod.GET)
    public Usuario GetUsuario(@PathVariable Integer id) {
        Usuario newUsuario = new Usuario();
        newUsuario.setId(id);
        newUsuario.setApellido("Velasquez");
        newUsuario.setEmail("Email@.com");
        newUsuario.setName("Luciano");
        newUsuario.setPassword("Password23");

        return newUsuario;
    }

    @RequestMapping(value = "usuarios",method = RequestMethod.GET)
    public List<Usuario> getUsuarios() {

        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "usuarios/{id}",method = RequestMethod.DELETE)
    public void deleteUsuario(@PathVariable Integer id){

        usuarioDao.delete(id);

    }

}
