package com.example.veiculo_service.repository;

import com.example.veiculo_service.model.Fabricante;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
    boolean existsByNomeIgnoreCase(@NotBlank String nome);
}
