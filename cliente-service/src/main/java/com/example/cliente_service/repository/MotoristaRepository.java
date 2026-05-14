package com.example.cliente_service.repository;

import com.example.cliente_service.model.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    boolean existsByEmail(String email);

    Optional<Motorista> findByEmail(String email);

    Optional<Motorista> findByNumeroCnh(String numeroCnh);
}