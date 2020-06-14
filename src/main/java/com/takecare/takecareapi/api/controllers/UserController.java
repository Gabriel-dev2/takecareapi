package com.takecare.takecareapi.api.controllers;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import com.takecare.takecareapi.api.dto.SubmitCreateRequestDTO;
import com.takecare.takecareapi.api.dto.SubmitEditUserRequestDTO;
import com.takecare.takecareapi.api.dto.SubmitResponseDTO;
import com.takecare.takecareapi.api.dto.UserResponseDTO;
import com.takecare.takecareapi.entities.Paciente;
import com.takecare.takecareapi.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "User", tags = "User", description = "Endpoint for user opereations.")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/user/list")
    @ApiOperation(value = "List all users data")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "A list of all users"),
            @ApiResponse(code = 404, message = "There are no registered users") })
    public ResponseEntity<Paciente> listAllUsers() {
        Paciente u = this.userService.listAll();
        return ResponseEntity.ok().body(u);
    }

    @GetMapping(path = "/user/getUser/{id}")
    @ApiOperation(value = "Select user")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "User Found"),
            @ApiResponse(code = 404, message = "User not found") })
    public ResponseEntity<UserResponseDTO> getUserbyId(@ApiParam("User Id") @Valid @PathVariable Integer id)
            throws InterruptedException, ExecutionException, IOException {
                    UserResponseDTO u = this.userService.findUserById(id);
                    ResponseEntity<UserResponseDTO> response = new ResponseEntity<>(
                        u, HttpStatus.OK
                    );
            return response;
        }
        
     @PostMapping(path = "/user/createUser")
     @ApiOperation(value = "Create user")
     @ApiResponses(value = {
         @ApiResponse(code = 200, message = "User Created"),
         @ApiResponse(code = 400, message = "User already exists")})   
     public ResponseEntity<SubmitResponseDTO> createUser(@RequestBody SubmitCreateRequestDTO submit) {
        SubmitResponseDTO response = this.userService.createUser(submit);
        return ResponseEntity.ok().body(response);
     }
     
     @PostMapping(path = "/user/editUser")
     @ApiOperation(value = "Edit User")
     @ApiResponses(value = {
         @ApiResponse(code = 200, message = "User Edited")
     })
     public ResponseEntity<SubmitResponseDTO> editUser(@RequestBody SubmitEditUserRequestDTO submit) {
         ResponseEntity<SubmitResponseDTO> response = null;

         try {
             SubmitResponseDTO responseDTO = this.userService.editUser(submit);
             if (responseDTO != null && responseDTO.getMessage().equals("Usuário editado com sucesso")) {
                 response = new ResponseEntity<SubmitResponseDTO>(responseDTO, HttpStatus.OK);
             } else {
                response = new ResponseEntity<SubmitResponseDTO>(responseDTO, HttpStatus.BAD_GATEWAY);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return response;
     }

     @GetMapping(path = "/user/getByCpf/{CPF}")
     @ApiOperation(value = "Select user")
     @ApiResponses(value = { @ApiResponse(code = 200, message = "User Found"),
            @ApiResponse(code = 404, message = "User not found") })
     public ResponseEntity<UserResponseDTO> getUserByCPF(@ApiParam("Paciente CPF") @Valid String cpf) {
        ResponseEntity<UserResponseDTO> response = null;
        try {
            UserResponseDTO dto = this.userService.findUserByCPF(cpf);
            if (dto.getPaciente() != null) {
                response = new ResponseEntity<UserResponseDTO>(dto, HttpStatus.OK);
            } else {
                response = new ResponseEntity<UserResponseDTO>(dto, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
     }

}