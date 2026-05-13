package com.example.locacao_service.dto.apolice;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
public class ApoliceSeguroResponseDto {

    private BigInteger id;

    private BigDecimal valorFranquia;

    private Boolean protecaoTerceiro;

    private Boolean protecaoCausasNaturais;

    private Boolean protecaoRoubo;
}
