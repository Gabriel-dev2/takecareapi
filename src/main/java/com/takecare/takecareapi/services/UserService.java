package com.takecare.takecareapi.services;

import com.takecare.takecareapi.api.dto.SubmitCreateRequestDTO;
import com.takecare.takecareapi.api.dto.SubmitEditUserRequestDTO;
import com.takecare.takecareapi.api.dto.SubmitResponseDTO;
import com.takecare.takecareapi.api.dto.UserResponseDTO;
import com.takecare.takecareapi.entities.Paciente;

public interface UserService {

    SubmitResponseDTO createUser(SubmitCreateRequestDTO request);

    UserResponseDTO findUserById(int id);

    Paciente findUserByName(String userName);

    UserResponseDTO findUserByCPF(String cpf);

    Paciente listAll();

    SubmitResponseDTO editUser(SubmitEditUserRequestDTO request);
}