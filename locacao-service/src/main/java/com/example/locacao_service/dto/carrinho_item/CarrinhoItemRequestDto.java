package com.example.locacao_service.dto.carrinho_item;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
public class CarrinhoItemRequestDto {

    @Positive
    private BigDecimal valorEstimado;

    @Positive
    private BigInteger carrinhoId;

    @Positive
    private BigInteger carroId;
}
