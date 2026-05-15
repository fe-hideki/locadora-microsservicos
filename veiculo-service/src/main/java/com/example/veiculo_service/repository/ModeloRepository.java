package com.example.veiculo_service.repository;

import com.example.veiculo_service.model.ModeloCarro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<ModeloCarro,Long> {

    boolean existsByDescricaoIgnoreCase(@NotBlank String descricao);
    
    @NotNull Long findModeloCarroById(Long id);
}
