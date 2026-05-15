package com.example.locacao_service.dto.carrinho;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
public class CarrinhoRequestDto {

    @Positive
    private BigInteger pessoaId;
}
