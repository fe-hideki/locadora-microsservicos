package com.example.locacao_service.dto.aluguel;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class AluguelRequestDto {

    @Positive
    private BigInteger pessoaId;

    @Positive
    private BigInteger carroId;

    @Positive
    private BigInteger apoliceId;
}
