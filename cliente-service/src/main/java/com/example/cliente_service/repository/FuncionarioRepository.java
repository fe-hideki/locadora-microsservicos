package com.example.cliente_service.repository;

import com.example.cliente_service.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    boolean existsByMatricula(String matricula);

    Optional<Funcionario> findByMatricula(String matricula);
}