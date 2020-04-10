package com.takecare.takecareapi.services;

import com.takecare.takecareapi.entities.User;

public interface UserService {

    User createUser(String userName, String userPassword, String userEmail, String userPlanCard);

    User findUserById(Long id);

    User findUserByName(String userName);

    User listAll();
}