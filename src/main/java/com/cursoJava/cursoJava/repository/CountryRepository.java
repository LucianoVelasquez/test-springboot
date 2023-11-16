package com.cursoJava.cursoJava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursoJava.cursoJava.models.Countries;

@Repository
public interface CountryRepository extends JpaRepository <Countries,Long> {

    public Countries findBytld(String tdl);
    public Countries findByname(String name);
    public List<Countries> findByNameIgnoreCaseStartingWith(String name);
    
} 
