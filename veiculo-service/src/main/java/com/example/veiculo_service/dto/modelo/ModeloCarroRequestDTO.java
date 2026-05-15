package com.example.veiculo_service.dto.modelo;

import com.example.veiculo_service.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModeloCarroRequestDTO {
    @NotBlank
    private String descricao;
    @NotNull
    private Long fabricanteId;
    @NotNull
    private Categoria categoria;
}
