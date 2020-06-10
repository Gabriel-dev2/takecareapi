package com.takecare.takecareapi.repository;

import java.util.List;
import java.util.Optional;

import com.takecare.takecareapi.entities.LoginAtendente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginAtendenteRepository extends JpaRepository<LoginAtendente, Integer> {
    List<LoginAtendente> findAll();

    @Query(value = "SELECT * FROM logatendente where logatendente.matricula =?1", nativeQuery = true)
    Optional<LoginAtendente> findByMatricula(String matricula);
}