package com.example.locacao_service.dto.aluguel;

import com.example.locacao_service.model.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
public class AluguelResponseDto {

    private BigInteger id;

    private BigInteger pessoaId;

    private BigInteger carroId;

    private LocalDateTime dataPedido;

    private LocalDateTime dataEntrega;

    private LocalDateTime dataDevolucao;

    private BigDecimal valorTotal;

    private Status status;

    private ApoliceSeguro apoliceSeguro;

    @Getter
    @Setter
    public class ApoliceSeguro {
        private BigInteger id;

        private BigDecimal valorFranquia;

        private Boolean protecaoTerceiro;

        private Boolean protecaoCausasNaturais;

        private Boolean protecaoRoubo;
    }
}
