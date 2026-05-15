package com.example.locacao_service.dto.pagamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
public class PagamentoRequestDto {

    @Positive
    private BigInteger aluguelId;

    @NotBlank
    private String metodo;

    @NotBlank
    private String status;

    @Positive
    private BigDecimal valor;
}
