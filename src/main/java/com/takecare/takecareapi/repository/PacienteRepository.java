package com.takecare.takecareapi.repository;

import java.util.List;

import com.takecare.takecareapi.entities.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    List<Paciente> findAll();

    Paciente findById(int Id);

    @Query(value = "SELECT * FROM paciente WHERE paciente.nome =?1", nativeQuery = true)
    Paciente findByName(String name);

    @Modifying
    @Transactional(readOnly = false)
    @Query(value = "UPDATE paciente SET paciente.nome =?1 WHERE paciente.id_paciente =?2", nativeQuery = true)
    int updateUserName(String nome, int idPaciente);

    @Modifying
    @Transactional(readOnly = false)
    @Query(value = "UPDATE paciente SET paciente.endereco =?1 WHERE paciente.id_paciente =?2", nativeQuery = true)
    int updateUserAddress(String endereco, int idPaciente);

    @Modifying
    @Transactional(readOnly = false)
    @Query(value = "UPDATE paciente SET paciente.numerocasa =?1 WHERE paciente.id_paciente =?2", nativeQuery = true)
    int updateUserAddressNumber(int numeroendereco, int idPaciente);

    @Modifying
    @Transactional(readOnly = false)
    @Query(value = "UPDATE paciente SET paciente.email =?1 WHERE paciente.id_paciente =?2", nativeQuery = true)
    int updateUserEmail(String email, int idPaciente);

    @Modifying
    @Transactional(readOnly = false)
    @Query(value = "UPDATE paciente SET paciente.id_planodesaude =?1 WHERE paciente.id_paciente =?2", nativeQuery = true)
    int updateUserHelthPlan(int idPlan, int idPaciente);

}