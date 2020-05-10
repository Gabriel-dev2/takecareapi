package com.takecare.takecareapi.services;

import com.takecare.takecareapi.api.dto.UserResponseDTO;
import com.takecare.takecareapi.entities.Paciente;

public interface UserService {

    String createUser(String userName, String cpf, String endereco, int numeroCasa);

    UserResponseDTO findUserById(int id);

    Paciente findUserByName(String userName);

    Paciente listAll();
}