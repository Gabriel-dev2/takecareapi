package com.takecare.takecareapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "planodesaude")

@Data
public class PlanoSaude {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_planodesaude")
    private int id;

    @Column(name = "nomedoplano")
    private String nomePlano;

    @Column(name = "categoria")
    private String categoria;
}