package com.example.veiculo_service.dto.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModeloCarroResponseDTO {
    private Long id;
    private String descricao;
    private String fabricanteNome;
    private String categoriaNome;
}
