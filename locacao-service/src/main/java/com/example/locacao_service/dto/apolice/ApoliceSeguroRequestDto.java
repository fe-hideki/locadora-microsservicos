package com.example.locacao_service.dto.apolice;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ApoliceSeguroRequestDto {

    @Positive
    private Double valorFranquia;

    private Boolean protecaoTerceiro;

    private Boolean protecaoCausasNaturais;

    private Boolean protecaoRoubo;
}
