package com.takecare.takecareapi.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "api/call", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Call Ambulance", tags = "Call Ambulance", description = "Endpoint for Call Ambulance")
public class CallEmergency {
    
}
