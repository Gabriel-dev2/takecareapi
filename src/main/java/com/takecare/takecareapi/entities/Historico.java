package com.takecare.takecareapi.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "historico")

@Data
@AllArgsConstructor
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhistorico")
    private Integer idHistorico;

    @Column(name = "datahoraa")
    private LocalDateTime dataHora;

    @Column(name = "placaAmbulancia")
    private String placaAmbulancia;

    @Column(name = "id_chamado")
    private int idChamado;

    @Column(name = "nomeSintoma")
    private String nomeSintoma;

    @Column(name = "nome_hospital")
    private String nomeHospital;

    @Column(name = "nomedoPlano")
    private String nomePlano;

    @Column(name = "id_paciente")
    private int idPaciente;

    @Column(name = "idlogatendente")
    private int idlogatendente;

    public Historico() {
    }

}