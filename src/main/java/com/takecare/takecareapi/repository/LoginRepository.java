package com.takecare.takecareapi.repository;

import java.util.List;
import java.util.Optional;

import com.takecare.takecareapi.entities.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository extends JpaRepository<Login, String>{
    List<Login> findAll();
    
    @Query(value = "SELECT * FROM login where login.cpf =?1", nativeQuery = true)
    Optional<Login> findByCpf(String cpf);
    
}