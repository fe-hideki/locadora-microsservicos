package com.example.locacao_service.dto.carrinho;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
public class CarrinhoResponseDto {

    private BigInteger id;

    private BigInteger pessoaId;

    private LocalDateTime criadoEm;
}
