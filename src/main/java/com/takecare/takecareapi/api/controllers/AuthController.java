package com.takecare.takecareapi.api.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "api/login", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Auth", tags = "Authenticator", description = "Endpoint for authentication")
public class AuthController {
    
}