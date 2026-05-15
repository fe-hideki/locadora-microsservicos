package com.example.veiculo_service.dto.fabricante;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FabricanteResponseDTO {

    private Long id;
    private String nome;
}
