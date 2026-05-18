package com.example.locacao_service.dto.carrinho;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
public class CarrinhoResponseDto {

    private Long id;

    private Long pessoaId;

    private LocalDateTime criadoEm;
}
