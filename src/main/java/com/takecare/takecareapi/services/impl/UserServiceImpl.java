package com.takecare.takecareapi.services.impl;

import com.takecare.takecareapi.entities.Paciente;
import com.takecare.takecareapi.services.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public Paciente createUser(String userName, String userPassword, String userEmail, String userPlanCard) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Paciente findUserById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Paciente findUserByName(String userName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Paciente listAll() {
        Paciente u = new Paciente(1, "Gabriel Lucas", "gabriel.lima@testedeemail.com.br", "abcd@12345", "55214620156");
        return u;
    }

}