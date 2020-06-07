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
@Table(name = "sintomas")


@Data
@AllArgsConstructor
public class Sintomas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsintomas")
    private Integer idSintoma;

    @Column(name = "nomesintoma")
    private String nome;

    public Sintomas(){}
}