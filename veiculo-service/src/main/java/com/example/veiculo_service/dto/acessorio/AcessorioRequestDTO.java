package com.example.veiculo_service.dto.acessorio;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AcessorioRequestDTO {

    @NotBlank
    private String descricao;
}
