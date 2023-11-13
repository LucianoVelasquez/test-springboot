package com.cursoJava.cursoJava.dao;

import java.util.List;

import com.cursoJava.cursoJava.models.Usuario;

public interface usuarioDao {

    List<Usuario> getUsuarios();

    void delete(Integer id);

    void registrarUsuario(Usuario usuario);

    

}
