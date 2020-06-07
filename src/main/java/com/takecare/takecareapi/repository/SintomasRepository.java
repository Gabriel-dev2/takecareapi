package com.takecare.takecareapi.repository;

import java.util.List;

import com.takecare.takecareapi.entities.Sintomas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SintomasRepository extends JpaRepository<Sintomas, Integer> {
    List<Sintomas> findAll();

    Sintomas findById(int id);

    
    
}