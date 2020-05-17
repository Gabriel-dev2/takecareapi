package com.takecare.takecareapi.repository;

import java.util.List;

import com.takecare.takecareapi.entities.Login;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, String>{
    List<Login> findAll();
}