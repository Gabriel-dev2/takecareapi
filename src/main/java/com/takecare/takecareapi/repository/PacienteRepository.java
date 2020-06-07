package com.takecare.takecareapi.repository;

import java.util.List;

import com.takecare.takecareapi.entities.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    List<Paciente> findAll();

    Paciente findById(int Id);

}