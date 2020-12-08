package com.takecare.takecareapi.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "api/history", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Service History", tags = "Users Service History", description = "Endpoint for service history")
public class ServiceHistory {
    
}
