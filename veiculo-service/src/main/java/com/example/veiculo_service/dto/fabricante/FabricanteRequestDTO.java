package com.example.veiculo_service.dto.fabricante;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FabricanteRequestDTO {

    @NotBlank
    private String nome;
}
