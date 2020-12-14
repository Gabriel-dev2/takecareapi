package com.takecare.takecareapi.repository;

import java.util.List;
import java.util.Optional;

import com.takecare.takecareapi.entities.Chamado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmergenciaRepository extends JpaRepository<Chamado, Integer> {
    List<Chamado> findAll();

    @Query(value = "SELECT * FROM chamado where chamado.id_paciente =?1", nativeQuery = true)
    Optional<Chamado> findByIdPaciente(Integer idPaciente);
}
