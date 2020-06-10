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
@Table(name = "logatendente")

@Data
@AllArgsConstructor
public class LoginAtendente {

    public LoginAtendente(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlogatendente")
    private int idAtendente;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "nomeatendente")
    private String nome;

    @Column(name = "senha")
    private String senha;
    
}