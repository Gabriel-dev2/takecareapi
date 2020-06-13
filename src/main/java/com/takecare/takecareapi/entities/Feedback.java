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
@Table(name = "feedback")

@Data
@AllArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_feedback")
    private int idFeedback;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "avaliacao")
    private String avaliacao;

    @Column(name = "id_chamado")
    private int idChamado;

    public Feedback() {
        
    }
}