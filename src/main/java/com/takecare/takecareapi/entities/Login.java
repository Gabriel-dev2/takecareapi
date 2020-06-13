package com.takecare.takecareapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "login")

@Data
@AllArgsConstructor
public class Login {

    public Login() {
	}

    @Id
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "senha")
    private String senha;



    
}