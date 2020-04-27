package com.takecare.takecareapi.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import com.takecare.takecareapi.dto.UserSubmitDTO;
import com.takecare.takecareapi.entities.User;
import com.takecare.takecareapi.services.FirebaseService;
import com.takecare.takecareapi.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import io.swagger.annotations.*;

@RestController
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "User", tags = "User", description = "Endpoint for user opereations.")
public class UserController {

    private UserService userService;
    private FirebaseService firebaseService;

    @Autowired
    public UserController(UserService userService, FirebaseService firebaseService) {
        this.userService = userService;
        this.firebaseService = firebaseService;
    }

    @GetMapping(path = "/user/list")
    @ApiOperation(value = "List all users data")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "A list of all users"),
            @ApiResponse(code = 404, message = "There are no registered users") })
    public ResponseEntity<User> listAllUsers() {
        User u = this.userService.listAll();
        return ResponseEntity.ok().body(u);
    }

    @GetMapping(path = "/user/getUser/{id}")
    @ApiOperation(value = "Select user")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "User Found"),
            @ApiResponse(code = 404, message = "User not found") })
    public ResponseEntity<String> getUserbyId(@ApiParam("User Id") @Valid @PathVariable String id)
            throws InterruptedException, ExecutionException, IOException {
            String u = this.firebaseService.selectUserFromDb("paciente", id);

            return ResponseEntity.ok().body(u);
        }   

}