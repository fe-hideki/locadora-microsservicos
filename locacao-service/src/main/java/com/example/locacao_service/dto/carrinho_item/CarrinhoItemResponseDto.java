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

    private Long id;

    private Long carroId;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private Double valorEstimado;

    private Carrinho carrinho;

    @Getter
    @Setter
    public class Carrinho{
        private Long id;

        private Long pessoaId;

        private LocalDateTime criadoEm;
    }
}
