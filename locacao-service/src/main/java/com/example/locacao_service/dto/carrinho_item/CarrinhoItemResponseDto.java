package com.example.locacao_service.dto.carrinho_item;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CarrinhoItemResponseDto {

    private BigInteger id;

    private BigInteger carroId;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private BigDecimal valorEstimado;

    private Carrinho carrinho;

    @Getter
    @Setter
    public class Carrinho{
        private BigInteger id;

        private BigInteger pessoaId;

        private LocalDateTime criadoEm;
    }
}
