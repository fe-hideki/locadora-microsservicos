package com.example.veiculo_service.repository;

import com.example.veiculo_service.model.Acessorio;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {
    boolean existsByDescricaoIgnoreCase(@NotBlank String descricao);
}
