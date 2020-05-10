package com.takecare.takecareapi.services;

import com.takecare.takecareapi.entities.Paciente;

public interface UserService {

    Paciente createUser(String userName, String userPassword, String userEmail, String userPlanCard);

    Paciente findUserById(Long id);

    Paciente findUserByName(String userName);

    Paciente listAll();
}