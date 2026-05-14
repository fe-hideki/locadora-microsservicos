package com.example.veiculo_service.dto.carro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarroRequestDTO {
    @NotBlank
    private String placa;
    @NotBlank
    private String chassi;
    @NotBlank
    private String cor;
    @NotNull
    private BigDecimal valorDiaria;
    @NotNull
    private Long modeloId;

    private List<Long> acessorioIds = new ArrayList<>();

}
