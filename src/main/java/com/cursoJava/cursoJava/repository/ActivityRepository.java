package com.cursoJava.cursoJava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursoJava.cursoJava.models.Activities;

@Repository
public interface ActivityRepository extends JpaRepository<Activities,Long>{

}
