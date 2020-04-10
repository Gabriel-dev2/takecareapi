package com.takecare.takecareapi.services.impl;

import com.takecare.takecareapi.entities.User;
import com.takecare.takecareapi.services.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User createUser(String userName, String userPassword, String userEmail, String userPlanCard) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findUserById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findUserByName(String userName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User listAll() {
        User u = new User(1l, "Gabriel Lucas", "gabriel.lima@testedeemail.com.br", "abcd@12345", "55214620156");
        return u;
    }

}