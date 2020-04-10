package com.takecare.takecareapi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserSubmitDTO {

    @NotNull
    private String userName;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String planCard;
}