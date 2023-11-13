package com.cursoJava.cursoJava.dao;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursoJava.cursoJava.models.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class usuarioDaoImp implements usuarioDao {

    @PersistenceContext
    EntityManager entityManager; 

    @Override
    public List<Usuario> getUsuarios() {

        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void delete(Integer id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }    
} 
