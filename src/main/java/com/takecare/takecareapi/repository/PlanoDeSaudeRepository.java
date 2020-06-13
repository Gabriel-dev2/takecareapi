package com.takecare.takecareapi.repository;

import java.util.List;

import com.takecare.takecareapi.entities.PlanoSaude;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoDeSaudeRepository extends JpaRepository<PlanoSaude, Integer>{

    List<PlanoSaude> findAll();
    
    PlanoSaude findById(int id);
}